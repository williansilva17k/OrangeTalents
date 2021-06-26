package com.desafio.OrangeTalents.service;

import com.desafio.OrangeTalents.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity saveUser(User user);

    ResponseEntity getUser(String cpf);

    ResponseEntity getUserByCpf(String cpf);

}
