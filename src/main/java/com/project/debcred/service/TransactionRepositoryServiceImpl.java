package com.project.debcred.service;

import com.project.debcred.dto.Transaction;
import com.project.debcred.models.TransactionEntity;
import com.project.debcred.models.UserEntity;
import com.project.debcred.repositories.TransactionRepository;
import com.project.debcred.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionRepositoryServiceImpl implements TransactionRepositoryService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Integer addTransaction(Transaction transaction){
        Optional<UserEntity> userEntity = userRepository.findById(transaction.getUserId());
        if(userEntity.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            TransactionEntity transactionEntity = modelMapper.map(transaction, TransactionEntity.class);
            transactionEntity.setUserEntity(userEntity.get());
            transactionRepository.save(transactionEntity);
            return(transactionEntity.getId());
        }
        else {
            return (-1);
        }

    }




}
