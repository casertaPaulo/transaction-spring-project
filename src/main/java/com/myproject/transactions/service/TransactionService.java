package com.myproject.transactions.service;

import com.myproject.transactions.dto.RequestTransactionDTO;
import com.myproject.transactions.entity.TransactionEntity;
import com.myproject.transactions.entity.UserEntity;
import com.myproject.transactions.entity.enums.UserTransactionType;
import com.myproject.transactions.entity.enums.UserType;
import com.myproject.transactions.exception.transaction.InsufficientBalanceException;
import com.myproject.transactions.exception.transaction.InvalidAmountException;
import com.myproject.transactions.exception.transaction.SameUserTransactionException;
import com.myproject.transactions.repository.TransactionRepository;
import com.myproject.transactions.exception.transaction.UserTypeInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService implements Validate<TransactionEntity> {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;


    public List<TransactionEntity> listAllTransactions() {
        return transactionRepository.findAll();
    }

    public TransactionEntity createTransaction(RequestTransactionDTO request) throws Exception {
        UserEntity sender = userService.getUserById(request.senderId(), UserTransactionType.SENDER);
        UserEntity receiver = userService.getUserById(request.receiverId(), UserTransactionType.RECEIVER);

        TransactionEntity transaction = new TransactionEntity(sender, receiver, request.amount());

        // validate the transaction
        validate(transaction);

        return transactionRepository.save(new TransactionEntity(sender, receiver, request.amount()));
    }

    @Override
    public void validate(TransactionEntity transaction) {
        if (transaction.getSender().getUserType().equals(UserType.SELLER)) throw new UserTypeInvalidException();
        if (transaction.getSender().getBalance().compareTo(transaction.getAmount()) < 0) throw new InsufficientBalanceException();
        if (transaction.getSender().equals(transaction.getReceiver())) throw new SameUserTransactionException();
        if (transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) throw new InvalidAmountException();

        doTransaction(transaction);
    }

    private void doTransaction(TransactionEntity transaction) {
        transaction.getSender().setBalance(transaction.getSender().getBalance().subtract(transaction.getAmount()));
        transaction.getReceiver().setBalance(transaction.getReceiver().getBalance().add(transaction.getAmount()));
    }

}
