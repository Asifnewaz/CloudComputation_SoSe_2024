package com.asif.cc_summer.service;

import com.asif.cc_summer.entity.Cart;
import com.asif.cc_summer.entity.UserEntity;
import com.asif.cc_summer.repository.CategoryRepository;
import com.asif.cc_summer.repository.LoginRepository;
import com.mysql.cj.callback.UsernameCallback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;

    public UserEntity createUser(String Username, String Password) {

       UserEntity userEntity = new UserEntity();
       userEntity.setUser_name(Username);
       userEntity.setPassword(Password);

        return  loginRepository.save(userEntity);
    }

    public String verifyLogin(String Username, String Password) {

        List<UserEntity> allData = loginRepository.findAll();
        for (int i = 0; i < allData.size(); i++) {
            UserEntity login =  allData.get(i);
            if (login.getUser_name().equals(Username)) {
                return "Login successful!";
            }
        }

        return "Invalid username or password. Login failed.";
    }
}
