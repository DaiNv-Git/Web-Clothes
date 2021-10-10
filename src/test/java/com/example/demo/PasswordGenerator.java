package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String rawPass = "dai223";
        String encodePassword = encoder.encode(rawPass);
        System.out.println(encodePassword);
    }
}
