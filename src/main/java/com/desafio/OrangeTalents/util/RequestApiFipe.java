package com.desafio.OrangeTalents.util;


import com.desafio.OrangeTalents.model.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "request", url = "${url.api_fipe}")
public interface RequestApiFipe {

    @RequestMapping("{type}/marcas/{marca_id}/modelos/{modelo_id}/anos/{ano}")
    Vehicle getVehicle(@RequestParam("type") String type, @RequestParam("marca_id") Integer marca_id,
                       @RequestParam("modelo_id") Integer modelo_id, @RequestParam("ano") String ano);
}
