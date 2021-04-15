package com.project.debcred.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Transaction {
    private Integer id;
    private Date date;
    private char type;
    private String source;
    private Double amount;
    private String currency;
    private Integer userId;
}
