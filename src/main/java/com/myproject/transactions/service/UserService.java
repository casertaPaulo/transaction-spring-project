package com.myproject.transactions.service;

import com.myproject.transactions.entity.UserEntity;
import com.myproject.transactions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) throws Exception {
        return userRepository.findUserById(id).orElseThrow(() -> new Exception("User not found!"));
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity user){
        return userRepository.save(user);
    }

}
