package com.project.debcred.service;

import com.project.debcred.models.UserEntity;

import java.util.ArrayList;
import java.util.List;

public interface UserRepositoryService {
    Integer createUser(UserEntity userEntity);
    List<UserEntity> listAllUsers();
    Integer deleteUser(Integer userId);
}
