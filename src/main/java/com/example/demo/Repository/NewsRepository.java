package com.example.demo.Repository;

import com.example.demo.Model.news;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<news,Integer> {
}
