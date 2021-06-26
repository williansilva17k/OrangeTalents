package com.desafio.OrangeTalents.controller.impl;

import com.desafio.OrangeTalents.controller.UserController;
import com.desafio.OrangeTalents.model.User;
import com.desafio.OrangeTalents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity saveUser(User user) {
        return userService.saveUser(user);
    }

    @Override
    public ResponseEntity getUser(String cpf) {
        return userService.getUser(cpf);
    }

    @Override
    public ResponseEntity getUserByCpf(String cpf){
        return userService.getUserByCpf(cpf);
    }
}
