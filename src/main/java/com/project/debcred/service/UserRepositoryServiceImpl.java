package com.project.debcred.service;

import com.project.debcred.models.UserEntity;
import com.project.debcred.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Integer createUser(UserEntity userEntity){
        userRepository.save(userEntity);
        return(userEntity.getId());
    }

    @Override
    public List<UserEntity> listAllUsers(){
        List<UserEntity> userList = (List<UserEntity>) userRepository.findAll();
        return (userList);
    }

    @Override
    public Integer deleteUser(Integer userId){
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if(userEntity.isPresent()) {
            UserEntity user = userEntity.get();
            userRepository.delete(user);
            return (user.getId());
        }
        else
            return(-1);
    }
}
