package com.gastos.controlgastosrest.repositorio;

import com.gastos.controlgastosrest.modelos.EgresoFijoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EgresoFijoRepositorio extends JpaRepository<EgresoFijoModelo, Integer> {

}
