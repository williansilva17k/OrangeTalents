package com.desafio.OrangeTalents.controller.impl;

import com.desafio.OrangeTalents.controller.VehicleController;
import com.desafio.OrangeTalents.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("veiculo")
public class VehicleControllerImpl implements VehicleController {

    @Autowired
    VehicleService vehicleService;


    @Override
    public ResponseEntity saveVeiculo(String cpf, String type, Integer marca_id, Integer modelo_id, String ano) {
        return vehicleService.saveVehicle(cpf, type, marca_id, modelo_id, ano);
    }
}
