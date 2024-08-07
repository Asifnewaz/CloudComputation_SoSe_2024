package com.asif.cc_summer.service;

import com.asif.cc_summer.entity.Cart;
import com.asif.cc_summer.entity.UserEntity;
import com.asif.cc_summer.repository.CategoryRepository;
import com.asif.cc_summer.repository.LoginRepository;
import com.mysql.cj.callback.UsernameCallback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Boolean verifyLogin(String Username, String Password) {

        List<UserEntity> allData = loginRepository.findAll();
        Boolean credentialMatched = false;

        for (int i = 0; i < allData.size(); i++) {
            UserEntity login =  allData.get(i);
            if (login.getUser_name().equals(Username) && login.getPassword().equals(Password)) {
                credentialMatched = true;
                break;
            }
        }

        return  credentialMatched;
    }

    public Optional<UserEntity> getUserDetails(String Username, String Password) {

        List<UserEntity> allData = loginRepository.findAll();

        for (UserEntity login : allData) {
            if (login.getUser_name().equals(Username) && login.getPassword().equals(Password)) {
                return Optional.of(login);
            }
        }
        return Optional.empty();
    }
}
