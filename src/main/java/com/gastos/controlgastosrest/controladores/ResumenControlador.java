package com.gastos.controlgastosrest.controladores;

import com.gastos.controlgastosrest.DTO.ResumenDTO;
import com.gastos.controlgastosrest.servicios.ResumenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/resumen")
public class ResumenControlador {


    @Autowired
    private ResumenServicio resumenServicio;

    @GetMapping("/usuario/{idUsuario}/{porcentaje}")
    public ResponseEntity<ResumenDTO> obtenerResumen(
            @PathVariable Integer idUsuario,
            @PathVariable BigDecimal porcentaje) {
        ResumenDTO resumen =
                resumenServicio.obtenerResumenPorUsuario(idUsuario, porcentaje);

        return ResponseEntity.ok(resumen);
    }
}
