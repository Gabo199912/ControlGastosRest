package com.gastos.controlgastosrest.servicios;

import com.gastos.controlgastosrest.modelos.CategoriaModelo;
import com.gastos.controlgastosrest.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CategoriaServicio {
    private final CategoriaRepositorio categoriaRepositorio;

    @Autowired
    public CategoriaServicio(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    public CategoriaModelo guardarCategoria(CategoriaModelo categoria) {
        return categoriaRepositorio.save(categoria);
    }

    public CategoriaModelo buscarCategoriaPorId(Integer idCategoria){
        return categoriaRepositorio.findById(idCategoria).orElse(null);
    }

    public boolean eliminarCategoria(Integer idCategoria){
        if (idCategoria == null){
            System.out.printf("idCategoria es requerido");
            return false;
        }

        categoriaRepositorio.deleteById(idCategoria);
        return true;
    }
}
