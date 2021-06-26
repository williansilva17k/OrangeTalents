package com.desafio.OrangeTalents.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface VehicleController {

    @PostMapping(value = "/{type}/marcas/{marca_id}/modelos/{modelo_id}/anos/{ano}/user/{cpf}")
    ResponseEntity saveVeiculo(@PathVariable String cpf, @PathVariable String type,
                               @PathVariable Integer marca_id, @PathVariable Integer modelo_id,
                               @PathVariable String ano);
}
