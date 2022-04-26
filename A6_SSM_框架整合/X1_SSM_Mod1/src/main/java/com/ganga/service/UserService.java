package com.ganga.service;

import com.ganga.pojo.User;

import java.util.List;

public interface UserService {

    int addUser(String username);

    List<User> userAll();

}
