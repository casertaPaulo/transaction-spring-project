package com.myproject.transactions.service;

import com.myproject.transactions.dto.OrderDTO;
import com.myproject.transactions.dto.TransactionDTO;
import com.myproject.transactions.entity.AnnouncementEntity;
import com.myproject.transactions.entity.OrderEntity;
import com.myproject.transactions.entity.TransactionEntity;
import com.myproject.transactions.entity.UserEntity;
import com.myproject.transactions.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AnnouncementService announcementService;


    public List<OrderEntity> listAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity createOrder(OrderDTO orderDTO) throws Exception {
        // capturing the announcement (contains product and seller information)
        AnnouncementEntity announcement = announcementService.getAnnouncementById(orderDTO.getAnnouncementId());

        // capturing the user that will buy
        UserEntity buyer = userService.getUserById(orderDTO.getBuyerId());

        // making the transaction between buyer and seller, and the amount of that transaction
        // is the product price
        TransactionDTO transactionDTO = new TransactionDTO(
                buyer.getId(), announcement.getSeller().getId(), announcement.getProduct().getPrice());

        TransactionEntity transaction = transactionService.createTransaction(transactionDTO);


        return orderRepository.save(new OrderEntity(announcement, buyer, transaction));
    }
}
