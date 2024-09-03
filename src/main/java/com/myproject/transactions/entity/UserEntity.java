package com.myproject.transactions.entity;

import com.myproject.transactions.entity.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "users")
@Table(name = "users")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private UserType userType;



    public UserEntity(String fullName, String document, String email, String password, BigDecimal balance, UserType userType) {
        this.fullName = fullName;
        this.document = document;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.userType = userType;
    }


}
