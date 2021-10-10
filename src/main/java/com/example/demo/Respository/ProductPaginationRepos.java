package com.example.demo.Respository;

import com.example.demo.Model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductPaginationRepos extends PagingAndSortingRepository<Products,Integer> {
    @Query("SELECT p from Products p where "+"concat(p.product_id,p.name,p.category,p.description)"+"like %?1%")
    public Page<Products> findAll(String keyword, Pageable pageable);
}
