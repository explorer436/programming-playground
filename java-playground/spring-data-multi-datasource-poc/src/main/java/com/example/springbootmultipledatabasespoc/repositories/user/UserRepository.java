package com.example.springbootmultipledatabasespoc.repositories.user;

import com.example.springbootmultipledatabasespoc.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { }
