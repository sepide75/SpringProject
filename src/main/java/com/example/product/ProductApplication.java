package com.example.product;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProductApplication implements CommandLineRunner {
    private ProductRepository productRepository;

    @Autowired
    public void ProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Product testProduct = new Product();
        testProduct.setName("products");
        testProduct.setType("test");
        testProduct.setCategory("s");
        testProduct.setDescription("this is test");
        productRepository.save(testProduct);
    }
}
