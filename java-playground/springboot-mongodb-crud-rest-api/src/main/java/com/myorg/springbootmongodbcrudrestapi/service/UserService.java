package com.myorg.springbootmongodbcrudrestapi.service;

import java.util.List;

import com.myorg.springbootmongodbcrudrestapi.model.User;

public interface UserService {
	User createUser(User user);

    User updateUser(User user);

    List < User > getAllUsers();

    User getUserById(String userId);

    void deleteUser(String userId);
}
