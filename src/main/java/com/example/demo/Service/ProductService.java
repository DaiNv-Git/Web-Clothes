package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Products;
import com.example.demo.Respository.ProductRpos;

import java.util.List;

@Service
public class ProductService{
@Autowired
ProductRpos productRpos;
    public List<Products > listAll(String keyword){
        if(keyword !=null){
        return productRpos.findAll(keyword);
        }
    return  productRpos.findAll();
}
    public Page<Products> findPaginated(int pageNo,int pageSize,String keyword){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return  this.productRpos.findAll(pageable);
    }
}
