package com.example.product.service;

import com.example.product.converter.ProductConverter;
import com.example.product.dto.ProductDto;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductConverter productConverter;

    private Logger LOG = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public void ProductConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    @Autowired
    public void ProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto getProduct(String id) throws Exception {
        LOG.info("get product with id" + id);
        Optional<Product> p = productRepository.findById(id);
        Product product;
        if (p.isPresent()) product = p.get();
        else throw new Exception("product doesn't exist");
        ProductDto productDto = productConverter.entityToDto(product);
        return productDto;
    }

    public ProductDto createProduct(ProductDto productDto) throws Exception {
        try {
            LOG.info("saving product...");
            Product p = productConverter.dtoTOEntity(productDto);
            Product productToSave = productRepository.save(p);
            productDto.setId(productToSave.getId());
            return productDto;

        } catch (Exception e) {
            LOG.info("product doesn't exist");
            throw new Exception(e.getMessage());
        }
    }

    public void updateProduct(ProductDto productTOUpdate, String id) throws Exception {
        Optional<Product> p = productRepository.findById(id);
        Product foundProduct = null;
        if (p.isPresent()) foundProduct = p.get();
        try {
            foundProduct.setName(productTOUpdate.getName());
            foundProduct.setType(productTOUpdate.getType());
            foundProduct.setCategory(productTOUpdate.getCategory());
            foundProduct.setDescription(productTOUpdate.getDescription());
            productRepository.save(foundProduct);
        } catch (Exception e) {
            LOG.info("error to update product");
            throw new Exception(e.getMessage());
        }
    }

    public void deleteProduct(String id) throws Exception {
        Optional<Product> p = productRepository.findById(id);
        Product product = null;
        if (p.isPresent()) product = p.get();
        try {
            LOG.info("delete product");
            productRepository.delete(product);
        } catch (Exception e) {
            LOG.info("product doesn't exist");
            throw new Exception(e.getMessage());
        }
    }
}
