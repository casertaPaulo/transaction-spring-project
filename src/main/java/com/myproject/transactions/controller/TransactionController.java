package com.myproject.transactions.controller;

import com.myproject.transactions.dto.TransactionDTO;
import com.myproject.transactions.entity.TransactionEntity;
import com.myproject.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionEntity>> listAllTransaction() {
        return new ResponseEntity<>(transactionService.listAllTransactions(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TransactionEntity> createTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception {
        return new ResponseEntity<>(transactionService.createTransaction(transactionDTO), HttpStatus.CREATED);
    }



}
