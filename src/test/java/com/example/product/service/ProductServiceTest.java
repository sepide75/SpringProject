package com.example.product.service;

import com.example.product.dto.ProductDto;
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
}