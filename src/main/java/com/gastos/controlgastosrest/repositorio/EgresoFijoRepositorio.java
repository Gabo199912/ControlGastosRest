package com.gastos.controlgastosrest.repositorio;

import com.gastos.controlgastosrest.modelos.EgresoFijoModelo;
import com.gastos.controlgastosrest.modelos.IngresoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EgresoFijoRepositorio extends JpaRepository<EgresoFijoModelo, Integer> {
    List<EgresoFijoModelo> findByUsuario_IdUsuario(Integer idUsuario);
}
