package com.example.product.converter;

import com.example.product.dto.ProductDto;
import com.example.product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductDto entityToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setType(product.getType());
        dto.setCategory(product.getCategory());
        dto.setDescription(product.getDescription());
        return dto;
    }

    public Product dtoTOEntity(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setType(dto.getType());
        return product;
    }
}
