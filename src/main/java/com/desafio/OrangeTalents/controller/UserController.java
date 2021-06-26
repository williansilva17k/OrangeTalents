package com.desafio.OrangeTalents.controller;

import com.desafio.OrangeTalents.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserController {

    @PostMapping
    ResponseEntity saveUser(@RequestBody User user);

    @GetMapping(value = "/{cpf}")
    ResponseEntity getUser(@PathVariable String cpf);

    @GetMapping(value = "/u/{cpf}")
    ResponseEntity getUserByCpf(@PathVariable String cpf);
}
