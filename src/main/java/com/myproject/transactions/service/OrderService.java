package com.myproject.transactions.service;

import com.myproject.transactions.dto.RequestOrderDTO;
import com.myproject.transactions.dto.RequestTransactionDTO;
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

    public List<OrderEntity> listOrdersById(Long id) throws Exception {
        UserEntity user = userService.getUserById(id);
        return orderRepository.findOrderByBuyer(user).orElseThrow(() -> new RuntimeException("Erro"));
    }

    public OrderEntity createOrder(RequestOrderDTO requestOrderDTO) throws Exception {
        // capturing the announcement (contains product and seller information)
        AnnouncementEntity announcement = announcementService.getAnnouncementById(requestOrderDTO.announcementId());

        // capturing the user that will buy
        UserEntity buyer = userService.getUserById(requestOrderDTO.buyerId());

        // making the transaction between buyer and seller, and the amount of that transaction
        // is the product price
        RequestTransactionDTO RequestTransactionDTO = new RequestTransactionDTO(
                buyer.getId(), announcement.getSeller().getId(), announcement.getProduct().getPrice());

        TransactionEntity transaction = transactionService.createTransaction(RequestTransactionDTO);

        return orderRepository.save(new OrderEntity(announcement, buyer, transaction));
    }
}
