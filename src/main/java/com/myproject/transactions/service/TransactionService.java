package com.myproject.transactions.service;

import com.myproject.transactions.dto.TransactionDTO;
import com.myproject.transactions.entity.TransactionEntity;
import com.myproject.transactions.entity.UserEntity;
import com.myproject.transactions.entity.enums.UserTransactionType;
import com.myproject.transactions.entity.enums.UserType;
import com.myproject.transactions.exception.transaction.InsufficientBalance;
import com.myproject.transactions.exception.transaction.InvalidAmountException;
import com.myproject.transactions.exception.transaction.SameUserTransactionException;
import com.myproject.transactions.repository.TransactionRepository;
import com.myproject.transactions.exception.transaction.UserTypeInvalidException;
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

    public TransactionEntity createTransaction(TransactionDTO request) throws Exception {
        UserEntity sender = userService.getUserById(request.getSenderId(), UserTransactionType.SENDER);
        UserEntity receiver = userService.getUserById(request.getReceiverId(), UserTransactionType.RECEIVER);

        // validate the transaction
        validateTransaction(sender, receiver, request.getAmount());

        return transactionRepository.save(new TransactionEntity(sender, receiver, request.getAmount()));
    }

    private void validateTransaction(UserEntity sender, UserEntity receiver, BigDecimal amount) {
        if (sender.getUserType().equals(UserType.SELLER)) throw new UserTypeInvalidException();
        if (sender.getBalance().compareTo(amount) < 0) throw new InsufficientBalance();
        if (sender.equals(receiver)) throw new SameUserTransactionException();
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new InvalidAmountException();

        doTransaction(sender, receiver, amount);
    }

    private void doTransaction(UserEntity sender, UserEntity receiver, BigDecimal amount) {
        sender.setBalance(sender.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));
    }

}
