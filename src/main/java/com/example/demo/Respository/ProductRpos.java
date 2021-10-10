package com.example.demo.Respository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Products;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRpos extends JpaRepository<Products, Integer>{
    @Query("SELECT u FROM Products u WHERE u.category.Name = ?1")
    List<Products> getAllByNam(String name);
    List<Products> findAllByCategory(String name);
    @Query("SELECT p from Products p where "+"concat(p.product_id,p.name,p.category,p.description)"+"like %?1%")
    public List<Products> findAll(String keyword);

}
