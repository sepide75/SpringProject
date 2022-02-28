package com.example.product.exception;

public class ProductNotFoundException extends ProductException {
    public ProductNotFoundException() {

        super("your product not found");
    }

}
