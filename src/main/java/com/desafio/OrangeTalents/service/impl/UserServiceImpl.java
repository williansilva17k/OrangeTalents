package com.desafio.OrangeTalents.service.impl;

import com.desafio.OrangeTalents.model.User;
import com.desafio.OrangeTalents.model.Vehicle;
import com.desafio.OrangeTalents.repository.UserRepository;
import com.desafio.OrangeTalents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public ResponseEntity saveUser(User user) {
        try {
            User checkUser = userRepository.findByCpf(user.getCpf());

            if (checkUser != null) {
                return new ResponseEntity("Usuário ja existente", HttpStatus.BAD_REQUEST);
            }

            User userSaved = userRepository.save(user);

            return new ResponseEntity(userSaved, HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity("Erro ao cadastrar o usuário", HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity getUser(String cpf) {

        try {
            Calendar cal = Calendar.getInstance();
            Integer dayNow = cal.get(Calendar.DAY_OF_WEEK);

            User user = userRepository.findByCpfAndVehicle(cpf);

            if (user == null) {
                new ResponseEntity("Usuário não encontrado com este cpf  = " + cpf, HttpStatus.NOT_FOUND);
            }

            for (Vehicle v : user.getVehicles()) {
                if (v.getDay_of_week() == dayNow) {
                    v.setRotation(true);
                }
            }

            return new ResponseEntity(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getCause(), HttpStatus.NOT_FOUND);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity getUserByCpf(String cpf) {
        try {
            User user = userRepository.findByCpf(cpf);
            if (user == null) {
                new ResponseEntity("Usuário não encontrado com este cpf = " + cpf, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getCause(), HttpStatus.NOT_FOUND);
        }
    }

}

