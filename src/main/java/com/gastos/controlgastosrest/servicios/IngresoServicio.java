package com.gastos.controlgastosrest.servicios;

import com.gastos.controlgastosrest.DTO.IngresosDTO;
import com.gastos.controlgastosrest.modelos.CategoriaModelo;
import com.gastos.controlgastosrest.modelos.IngresoModelo;
import com.gastos.controlgastosrest.modelos.UsuariosModelo;
import com.gastos.controlgastosrest.repositorio.IngresoRepositorio;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class IngresoServicio {
    private final IngresoRepositorio ingresoRepositorio;
    private final CategoriaServicio categoriaServicio;
    private final UsuarioServicio usuarioServicio;

    @Autowired
    public IngresoServicio(IngresoRepositorio ingresoRepositorio, CategoriaServicio categoriaServicio, UsuarioServicio usuarioServicio) {
        this.ingresoRepositorio = ingresoRepositorio;
        this.categoriaServicio = categoriaServicio;
        this.usuarioServicio = usuarioServicio;
    }


    @Transactional
    public Boolean crearIngreso(IngresosDTO ingreso){

        UsuariosModelo usuario = usuarioServicio.buscarUsuarioPorId(ingreso.getIdUsuario());
        CategoriaModelo categoria = categoriaServicio.buscarCategoriaPorId(ingreso.getIdCategoria());

        if (usuario == null || categoria == null){
            return false;
        }

        IngresoModelo ingresoModelo = new IngresoModelo();
        ingresoModelo.setFecha(new Date(ingreso.getFecha().getTime()));
        ingresoModelo.setMonto(ingreso.getMonto());
        ingresoModelo.setDescripcion(ingreso.getDescripcion());
        ingresoModelo.setFuente(ingreso.getFuente());
        ingresoModelo.setUsuario(usuario);
        ingresoModelo.setCategoria(categoria);

        ingresoRepositorio.save(ingresoModelo);
        return true;
    }
}
