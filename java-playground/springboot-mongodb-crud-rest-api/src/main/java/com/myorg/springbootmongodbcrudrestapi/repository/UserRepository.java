package com.myorg.springbootmongodbcrudrestapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myorg.springbootmongodbcrudrestapi.model.User;

public interface UserRepository  extends MongoRepository < User, String > {

}
