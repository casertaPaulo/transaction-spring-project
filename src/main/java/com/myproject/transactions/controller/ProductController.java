package com.myproject.transactions.controller;

import com.myproject.transactions.entity.ProductEntity;
import com.myproject.transactions.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> listAllProducts() {
        return new ResponseEntity<>(productService.listAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }
}
