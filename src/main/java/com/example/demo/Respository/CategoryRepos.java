package com.example.demo.Respository;

import com.example.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepos  extends JpaRepository<Category,Integer> {

}
