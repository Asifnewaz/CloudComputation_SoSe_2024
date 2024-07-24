package com.asif.cc_summer.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password123";

    public String verifyLogin(String Username, String Password){
        if (CORRECT_USERNAME.equals(Username) && CORRECT_PASSWORD.equals(Password)) {
            return "Login successful!";
        } else {
            return "Invalid username or password. Login failed.";
        }
    }
}
