/*package com.asif.cc_summer.controllers;
import com.asif.cc_summer.service.LoginService;
import lombok.RequiredArgsConstructor;
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


}*/
package com.asif.cc_summer.controllers;

import com.asif.cc_summer.dto.response.BaseResponseDto;
import com.asif.cc_summer.entity.UserEntity;
import com.asif.cc_summer.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authentication")
public class LoginController {
    private final LoginService loginService;

    @PostMapping(value = "/createUser")
    public ResponseEntity<?> createUser(@RequestParam String username,
                                       @RequestParam String password) {
        UserEntity entity = loginService.createUser(username, password);

        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "Category added successfully";
        response.data = entity;
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return loginService.verifyLogin(username, password);
    }
}


