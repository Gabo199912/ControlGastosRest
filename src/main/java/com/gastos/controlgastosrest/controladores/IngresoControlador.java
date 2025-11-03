package com.gastos.controlgastosrest.controladores;

import com.gastos.controlgastosrest.DTO.IngresosDTO;
import com.gastos.controlgastosrest.servicios.IngresoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/ingresos")
public class IngresoControlador {

    private final IngresoServicio ingresoServicio;

    @Autowired
    public IngresoControlador(IngresoServicio ingresoServicio) {
        this.ingresoServicio = ingresoServicio;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> guardarIngreso(@RequestBody IngresosDTO ingreso){
        boolean ok =  ingresoServicio.crearIngreso(ingreso);

        if (ok){
            HashMap<String, Object> response = new HashMap<>();
            response.put("mensaje", "Ingreso creado");
            response.put("STATUS", 200);
            return ResponseEntity.ok(response);
        }else {
            HashMap<String, Object> response = new HashMap<>();
            response.put("mensaje", "Ingreso no creado");
            response.put("STATUS", 400);
            return ResponseEntity.badRequest().body(response);
        }
    }

}
