package com.george.blog.service;

import com.george.blog.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
