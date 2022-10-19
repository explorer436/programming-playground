package com.myorg.springbootmongodbcrudrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.springbootmongodbcrudrestapi.model.User;
import com.myorg.springbootmongodbcrudrestapi.service.UserService;

@RestController
public class UserController {
	@Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity < List < User >> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity < User > getUserById(@PathVariable String userId) {
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @PostMapping("/users")
    public ResponseEntity < User > createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity < User > updateUser(@PathVariable String userId, @RequestBody User user) {
        user.setId(userId);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }

    @DeleteMapping("/users/{id}")
    public HttpStatus deleteUser(@PathVariable String userId) {
        this.userService.deleteUser(userId);
        return HttpStatus.OK;
    }
}
