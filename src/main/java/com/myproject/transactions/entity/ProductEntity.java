package com.myproject.transactions.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name ="products")
@Entity(name ="products")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private BigDecimal price;

}
