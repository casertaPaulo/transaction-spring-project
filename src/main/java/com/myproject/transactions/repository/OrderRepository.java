package com.myproject.transactions.repository;

import com.myproject.transactions.entity.OrderEntity;
import com.myproject.transactions.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<List<OrderEntity>> findOrderByBuyer(UserEntity buyer);
}
