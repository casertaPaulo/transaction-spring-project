package com.myproject.transactions.repository;

import com.myproject.transactions.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserById(Long id);
    Optional<UserEntity> findUserByDocument(String document);
    boolean existsByDocument(String document);
    boolean existsByEmail(String email);
}
