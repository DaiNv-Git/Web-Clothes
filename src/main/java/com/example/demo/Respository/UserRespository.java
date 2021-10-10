package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Users;

public interface UserRespository extends JpaRepository<Users, Integer>{
    
	Users findByUserName(String userName);
}
