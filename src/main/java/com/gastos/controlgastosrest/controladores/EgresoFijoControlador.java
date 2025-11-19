package com.gastos.controlgastosrest.controladores;

import com.gastos.controlgastosrest.DTO.EgresoFijoDTO;
import com.gastos.controlgastosrest.modelos.EgresoFijoModelo;
import com.gastos.controlgastosrest.servicios.EgresoFijoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/egresos")
public class EgresoFijoControlador {
    private final EgresoFijoServicio egresoFijoServicio;

    @Autowired
    public EgresoFijoControlador(EgresoFijoServicio egresoFijoServicio) {
        this.egresoFijoServicio = egresoFijoServicio;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> guardarEgreso(@RequestBody EgresoFijoDTO egreso){
        boolean ok =  egresoFijoServicio.guardarEgreso(egreso);

        if (ok){
            HashMap<String, Object> response = new HashMap<>();
            response.put("mensaje", "Egreso creado");
            response.put("STATUS", 200);
            return ResponseEntity.ok(response);
        }else {
            HashMap<String, Object> response = new HashMap<>();
            response.put("mensaje", "Egreso no creado");
            response.put("STATUS", 400);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("listarPorId/{idUsuario}")
    public ResponseEntity<?> listarPorUsuario(@PathVariable Integer idUsuario){
        List<EgresoFijoModelo> egresos =  egresoFijoServicio.buscarEgresoPorId(idUsuario);
        return ResponseEntity.ok(egresos);
    }
}
