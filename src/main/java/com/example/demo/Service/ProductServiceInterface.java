package com.example.demo.Service;

import org.springframework.data.domain.Page;

import com.example.demo.Model.Products;

public interface ProductServiceInterface {
Page<Products> findPaginated(int pageNo,int pageSize);

}
