package com.myproject.transactions.service;

import com.myproject.transactions.entity.ProductEntity;
import com.myproject.transactions.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> listAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity findProductById(Long id) {
        return productRepository.findProductById(id).orElseThrow();
    }

    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public ProductEntity updateProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public ProductEntity deleteProduct(Long id) {
        ProductEntity product = productRepository.findProductById(id).orElseThrow();
        productRepository.delete(product);
        return product;
    }

}
