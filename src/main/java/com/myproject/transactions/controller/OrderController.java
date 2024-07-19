package com.myproject.transactions.controller;

import com.myproject.transactions.dto.OrderDTO;
import com.myproject.transactions.entity.OrderEntity;
import com.myproject.transactions.service.OrderService;
import lombok.Getter;
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
        return new ResponseEntity<>(orderService.listAllOrders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        return new ResponseEntity<>(orderService.createOrder(orderDTO), HttpStatus.CREATED);
    }
}
