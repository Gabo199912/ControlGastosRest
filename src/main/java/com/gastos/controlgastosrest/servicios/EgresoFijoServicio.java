package com.gastos.controlgastosrest.servicios;

import com.gastos.controlgastosrest.DTO.EgresoFijoDTO;
import com.gastos.controlgastosrest.modelos.CategoriaModelo;
import com.gastos.controlgastosrest.modelos.EgresoFijoModelo;
import com.gastos.controlgastosrest.modelos.UsuariosModelo;
import com.gastos.controlgastosrest.repositorio.EgresoFijoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EgresoFijoServicio {
    private final EgresoFijoRepositorio egresoFijoRepositorio;
    private final UsuarioServicio usuarioServicio;
    private final CategoriaServicio categoriaServicio;

    @Autowired
    public EgresoFijoServicio(EgresoFijoRepositorio egresoFijoRepositorio, UsuarioServicio usuarioServicio, CategoriaServicio categoriaServicio) {
        this.egresoFijoRepositorio = egresoFijoRepositorio;
        this.usuarioServicio = usuarioServicio;
        this.categoriaServicio = categoriaServicio;
    }

    @Transactional
    public boolean guardarEgreso(EgresoFijoDTO egreso){
        UsuariosModelo usuario = usuarioServicio.buscarUsuarioPorId(egreso.getIdUsurio());
        CategoriaModelo categoria = categoriaServicio.buscarCategoriaPorId(egreso.getIdCategoria());

        if (usuario == null || categoria == null){
            return false;
        }

        EgresoFijoModelo egresoModelo = new EgresoFijoModelo();
        egresoModelo.setCategoria(categoria);
        egresoModelo.setUsuario(usuario);
        egresoModelo.setNombre(egreso.getNombre());
        egresoModelo.setMonto(egreso.getMonto());
        egresoModelo.setFechaPago(egreso.getFechaPago());
        egresoModelo.setPagado(true);
        egresoFijoRepositorio.save(egresoModelo);
        return true;
    }


}
