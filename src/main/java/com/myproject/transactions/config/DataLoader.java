package com.myproject.transactions.config;

import com.myproject.transactions.entity.ProductEntity;
import com.myproject.transactions.entity.UserEntity;
import com.myproject.transactions.entity.enums.UserType;
import com.myproject.transactions.repository.ProductRepository;
import com.myproject.transactions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new UserEntity(
                "Paulo Henrique", "48902517829", "paulo@gmail.com", "123",
                new BigDecimal(10), UserType.COMMON));

        userRepository.save(new UserEntity(
                "Caleb Henrique", "58902517829", "caleb@gmail.com", "123",
                new BigDecimal(10), UserType.SELLER));

        productRepository.save(new ProductEntity("Desktop PC", 10, new BigDecimal(1000)));
    }
}
