package com.mak.clientui.clients;

import com.mak.clientui.beans.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "users", url = "localhost:9001")
public interface UserClient {

    @GetMapping(value = "v0/users")
    List<UserBean> getAllUsers();

    @GetMapping(value = "v0/users/{id}")
    UserBean getUser(@PathVariable("id") int id);

    @PostMapping(value = "")
    void createUser(@RequestBody UserBean userBean);
}
