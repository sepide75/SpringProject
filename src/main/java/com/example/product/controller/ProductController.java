package com.example.product.controller;

import com.example.product.converter.ProductConverter;
import com.example.product.dto.ProductDto;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/Products/")
public class ProductController {
    private ProductService productService;
    private ProductConverter productConverter;

    @Autowired
    public void ProductConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    @Autowired
    public void ProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "{id}")
    public ProductDto getProduct(@PathVariable(name = "id") String id) throws Exception {
        ProductDto product = productService.getProduct(id);
        return product;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto createProduct(@RequestBody ProductDto productToSave) throws Exception {
        return productService.createProduct(productToSave);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduct(@RequestBody ProductDto productToUpdate, @PathVariable(name = "id") String id) throws Exception {
        productService.updateProduct(productToUpdate, id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduct(@PathVariable(name = "id") String id) throws Exception {
        productService.deleteProduct(id);
    }

}
