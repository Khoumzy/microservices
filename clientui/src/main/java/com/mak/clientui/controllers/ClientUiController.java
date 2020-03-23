package com.mak.clientui.controllers;

import com.mak.clientui.beans.UserBean;
import com.mak.clientui.clients.ClockinClient;
import com.mak.clientui.clients.UserClient;
import com.mak.clientui.controllers.vm.ClockinWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientUiController {
    private static final Logger logger = LoggerFactory.getLogger(ClientUiController.class);

    @Autowired
    private UserClient userClient;

    @Autowired
    private ClockinClient clockinClient;

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserBean>> getUsers(){
        List<UserBean> users = userClient.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @PostMapping(value = "/clockins")
    public ResponseEntity clockin(@RequestBody ClockinWrapper clockinWrapper){


        UserBean user = userClient.getUser(clockinWrapper.getUserId());

        logger.info("User " + user.toString());

        clockinClient.clockin(clockinWrapper);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
