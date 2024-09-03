package com.myproject.transactions.controller;

import com.myproject.transactions.dto.RequestOrderDTO;
import com.myproject.transactions.entity.OrderEntity;
import com.myproject.transactions.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderEntity>> listAllOrders() {
        return ResponseEntity.ok(orderService.listAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderEntity>> listOrdersByUserID (@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(orderService.listOrdersById(id));
    }

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody RequestOrderDTO requestOrderDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(requestOrderDTO));
    }
}
