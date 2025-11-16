package com.gastos.controlgastosrest.controladores;

import com.gastos.controlgastosrest.modelos.CategoriaModelo;
import com.gastos.controlgastosrest.servicios.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaControlador {

    private final CategoriaServicio categoriaServicio;

    @Autowired
    public CategoriaControlador(CategoriaServicio categoriaServicio) {
        this.categoriaServicio = categoriaServicio;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> guardarUsuario(@RequestBody CategoriaModelo categoria) {
        String nombre = categoria.getNombre();
        String tipo = categoria.getTipo();

        if (nombre == null || tipo == null){
            HashMap<String, Object> response = new HashMap<>();
            response.put("mensaje", "Campos vacios");
            response.put("STATUS", 400);
            return ResponseEntity.badRequest().body(response);
        }

        categoriaServicio.guardarCategoria(categoria);
        HashMap<String, Object> response = new HashMap<>();
        response.put("mensaje", "Categoria creada");
        response.put("STATUS", 200);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarCategorias(){
        List<CategoriaModelo> categorias = categoriaServicio.buscarCategorias();

        return ResponseEntity.ok(categorias);
    }
}
