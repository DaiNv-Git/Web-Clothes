package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer>{

	Roles findByName(String name);
}
