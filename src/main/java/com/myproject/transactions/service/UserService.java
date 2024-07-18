package com.myproject.transactions.service;

import com.myproject.transactions.entity.UserEntity;
import com.myproject.transactions.entity.UserTransactionType;
import com.myproject.transactions.entity.UserType;
import com.myproject.transactions.exception.DocumentAlreadyExistException;
import com.myproject.transactions.exception.EmailAlreadyExistException;
import com.myproject.transactions.exception.UserNotFoundException;
import com.myproject.transactions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) throws Exception {
        return userRepository.findUserById(id).orElseThrow(UserNotFoundException::new);
    }

    public UserEntity getUserById(Long id, UserTransactionType userType) {
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException(userType));
    }

    public UserEntity createUser(UserEntity user) {
        validateUser(user);
        return userRepository.save(user);
    }

    private void validateUser(UserEntity user)  {
        if (userRepository.existsByDocument(user.getDocument())) {
            throw new DocumentAlreadyExistException();
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistException();
        }
    }

    public UserEntity updateUser(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity deleteUser(Long id) throws Exception {
        UserEntity user = userRepository.findUserById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
        return user;
    }

}
