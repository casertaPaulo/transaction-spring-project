package com.myproject.transactions.controller;

import com.myproject.transactions.entity.ProductEntity;
import com.myproject.transactions.service.ProductService;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(productService.listAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> findProductById(@PathVariable("id") Long id ) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

    @PutMapping
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductEntity> deleteProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
