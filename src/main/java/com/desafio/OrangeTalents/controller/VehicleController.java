package com.desafio.OrangeTalents.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface VehicleController {
    //http://localhost:8080/veiculo/carros/marcas/59/modelos/5940/anos/2014-3/user/13086205601
    //http://localhost:8080/veiculo/carros/marcas/10/modelos/259/anos/1994-1/user/13086205601
    @PostMapping(value = "/{type}/marcas/{marca_id}/modelos/{modelo_id}/anos/{ano}/user/{cpf}")
    ResponseEntity saveVeiculo(@PathVariable String cpf, @PathVariable String type,
                               @PathVariable Integer marca_id, @PathVariable Integer modelo_id,
                               @PathVariable String ano);
}
