package com.desafio.OrangeTalents.service;

import org.springframework.http.ResponseEntity;

public interface VehicleService {

    ResponseEntity saveVehicle(String cpf, String type, Integer marca_id, Integer modelo_id, String ano);
}
