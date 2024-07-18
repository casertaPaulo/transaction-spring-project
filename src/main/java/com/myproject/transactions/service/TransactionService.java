package com.myproject.transactions.service;

import com.myproject.transactions.dto.TransactionDTO;
import com.myproject.transactions.entity.TransactionEntity;
import com.myproject.transactions.entity.UserEntity;
import com.myproject.transactions.entity.UserType;
import com.myproject.transactions.exception.InsufficientBalance;
import com.myproject.transactions.repository.TransactionRepository;
import com.myproject.transactions.exception.UserTypeInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;


    public List<TransactionEntity> listAllTransactions() {
        return transactionRepository.findAll();
    }

    public TransactionEntity createTransaction(TransactionDTO transaction) throws Exception {
        UserEntity sender = userService.getUserById(transaction.getSenderId());
        UserEntity receiver = userService.getUserById(transaction.getReceiverId());

        // validate the transaction
        validateTransaction(sender, receiver, transaction.getAmount());

        sender.setBalance(sender.getBalance().subtract(transaction.getAmount()));
        receiver.setBalance(receiver.getBalance().add(transaction.getAmount()));

        return transactionRepository.save(new TransactionEntity(sender, receiver, transaction.getAmount()));
    }

    private void validateTransaction(UserEntity sender, UserEntity receiver, BigDecimal amount) {
        if (sender.getUserType().equals(UserType.SELLER)) throw new UserTypeInvalidException();
        if (sender.getBalance().compareTo(amount) < 0) throw new InsufficientBalance();
    }

}
