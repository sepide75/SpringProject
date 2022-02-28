package com.example.product.service;

import com.example.product.dto.ProductDto;
import com.example.product.exception.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void createAndGetProduct() throws Exception {
        ProductDto productDto=new ProductDto("product","s","test","this is a test");
        ProductDto product=productService.createProduct(productDto);
        ProductDto getProduct=productService.getProduct(product.getId());
        org.assertj.core.api.Assertions.assertThat(getProduct.getName()).isEqualTo("product");
        org.assertj.core.api.Assertions.assertThat(getProduct.getType()).isEqualTo("s");
        org.assertj.core.api.Assertions.assertThat(getProduct.getCategory()).isEqualTo("test");
        org.assertj.core.api.Assertions.assertThat(getProduct.getDescription()).isEqualTo("this is a test");

    }

    @Test
    public void update()throws Exception{
        ProductDto productDto=new ProductDto("product","s","test","this is a test");
        ProductDto createProduct=productService.createProduct(productDto);
        ProductDto updateProduct=new ProductDto("editProduct",
                "editProduct",
                "category",
                "general");
        productService.updateProduct(updateProduct, productDto.getId());
        ProductDto getProduct=productService.getProduct(createProduct.getId());
        org.assertj.core.api.Assertions.assertThat(getProduct.getName()).isEqualTo("editProduct");
    }
    @Test
    public void delete() throws Exception {
        ProductDto productDto=new ProductDto("product","s","test","this is a test");
        ProductDto createProduct=productService.createProduct(productDto);
        productService.deleteProduct(createProduct.getId());
        Assertions.assertThrows(ProductNotFoundException.class,() ->{
            productService.getProduct(createProduct.getId());
        });


    }
}