package com.project.debcred.controller;

import com.project.debcred.dto.Transaction;
import com.project.debcred.models.TransactionEntity;
import com.project.debcred.models.UserEntity;
import com.project.debcred.service.TransactionRepositoryServiceImpl;
import com.project.debcred.service.UserRepositoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class appController {

    @Autowired
    private UserRepositoryServiceImpl userRepositoryService;

    @Autowired
    private TransactionRepositoryServiceImpl transactionRepositoryService;

    @PostMapping("/adduser")
    public ResponseEntity<String> addUser(@RequestBody UserEntity userEntity){
        Integer userId = userRepositoryService.createUser(userEntity);
        return(new ResponseEntity<>("Added new user with id "+userId.toString(), HttpStatus.OK));
    }

    @GetMapping("/listusers")
    public List<UserEntity> listUsers(){
        List<UserEntity> userList= userRepositoryService.listAllUsers();
        return (userList);
    }

    @DeleteMapping("/deleteuser")
    public ResponseEntity<String> deleteUser(@RequestParam Integer userId){
        Integer val = userRepositoryService.deleteUser(userId);
        if(val.equals(-1))
            return(new ResponseEntity<>("User doesn't Exist", HttpStatus.BAD_REQUEST));
        else
            return (new ResponseEntity<>("User deleted with id "+val.toString(), HttpStatus.OK));
    }

    @PostMapping("/addtransaction")
    public ResponseEntity<String> addTransaction(@RequestBody Transaction transaction){
        Integer transactionId = transactionRepositoryService.addTransaction(transaction);
        if(transactionId.equals(-1))
            return (new ResponseEntity<>("Invalid User Id", HttpStatus.BAD_REQUEST));
        else
            return(new ResponseEntity<>("Transaction added with id "+transactionId.toString(),HttpStatus.OK));
    }
}
