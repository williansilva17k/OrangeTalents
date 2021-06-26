package com.desafio.OrangeTalents.service.impl;

import com.desafio.OrangeTalents.model.User;
import com.desafio.OrangeTalents.model.Vehicle;
import com.desafio.OrangeTalents.repository.UserRepository;
import com.desafio.OrangeTalents.repository.VehicleRepository;
import com.desafio.OrangeTalents.service.VehicleService;
import com.desafio.OrangeTalents.util.RequestApiFipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    RequestApiFipe requestFipeApi;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public ResponseEntity saveVehicle(String cpf, String type, Integer marca_id, Integer modelo_id, String ano) {
        try {

            System.out.println(requestFipeApi + "/carros/" + "" + "" + "");
            Vehicle vehicle = requestFipeApi.getVehicle(type, marca_id, modelo_id, ano);

            char year = ano.charAt(3);

            if (year == '0' || year == '1') {
                vehicle.setDay_of_week(2);
            } else if (year == '2' || year == '3') {
                vehicle.setDay_of_week(3);
            } else if (year == '4' || year == '5') {
                vehicle.setDay_of_week(4);
            } else if (year == '6' || year == '7') {
                vehicle.setDay_of_week(5);
            } else if (year == '8' || year == '9') {
                vehicle.setDay_of_week(6);
            }

            User user = userRepository.findByCpf(cpf);

            if (user == null) {
                return new ResponseEntity("Necessrio um cpf valido!", HttpStatus.BAD_REQUEST);
            }

            vehicle.setUser(user);

            Vehicle vehicleSaved = vehicleRepository.save(vehicle);

            return new ResponseEntity(vehicleSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}


