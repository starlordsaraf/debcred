package com.project.debcred.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String company;

    @OneToMany(mappedBy = "userEntity")
    private Set<TransactionEntity> transactionEntitySet = new HashSet<>();
}
