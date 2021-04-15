package com.project.debcred.repositories;

import com.project.debcred.models.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity,Integer> {
}
