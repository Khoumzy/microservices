package com.mak.users.controllers;

import com.mak.users.beans.UserBean;
import com.mak.users.exceptions.UserNotFound;
import com.mak.users.models.User;
import com.mak.users.repositories.UserRepository;
import com.mak.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v0/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @GetMapping(value = "")
    public ResponseEntity<List<UserBean>> getAllUser(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserBean> getUser(@PathVariable int id){

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound("User not found :)"));

        return ResponseEntity.ok(userService.userToBean(user));
    }

    @PostMapping(value = "")
    public ResponseEntity createUser(@RequestBody UserBean userBean){
        userService.save(userBean);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
