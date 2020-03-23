package com.mak.users.services;

import com.mak.users.beans.UserBean;
import com.mak.users.models.User;
import com.mak.users.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public List<UserBean> findAll(){
        return userRepository.findAll().stream()
                             .map(user -> userToBean(user))
                             .collect(Collectors.toList());
    }

    public void save(UserBean userBean){
        User user = beanToUser(userBean);

        userRepository.save(user);
    }

    public User beanToUser(UserBean bean){
        User user = new User();

        BeanUtils.copyProperties(bean, user);

        return user;
    }

    public UserBean userToBean(User user){
        UserBean bean = new UserBean();
        BeanUtils.copyProperties(user, bean);

        return bean;
    }
}
