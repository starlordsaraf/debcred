package com.project.debcred.service;

import com.project.debcred.dto.Transaction;
import com.project.debcred.models.TransactionEntity;

public interface TransactionRepositoryService {

    Integer addTransaction(Transaction transaction);
}
