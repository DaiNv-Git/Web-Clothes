package com.example.demo.Respository;

import com.example.demo.Model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRespositorySecurity extends CrudRepository<Users,Integer> {
    @Query("select u from Users u where u.userName =:userName")
    public Users getUsersByUserName(@Param("userName") String userName);
}
