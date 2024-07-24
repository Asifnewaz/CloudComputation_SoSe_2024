package com.asif.cc_summer.controllers;

import com.asif.cc_summer.service.CartService;
import com.asif.cc_summer.service.LoginService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/Login")
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        String Username = username;
        String Password = password;
       String response = loginService.verifyLogin(Username, Password);

       return response;
    }


}


