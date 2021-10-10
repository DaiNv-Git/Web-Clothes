package com.example.demo.Security;

import com.example.demo.Model.Users;
import com.example.demo.Respository.UserRespository;
import com.example.demo.Respository.UserRespositorySecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRespositorySecurity Rpossecurity;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = Rpossecurity.getUsersByUserName(userName);
        if(user ==null){
            throw  new UsernameNotFoundException("could not User");
        }
        return new MyUserDetail(user);
    }
}
