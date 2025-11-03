package com.gastos.controlgastosrest.repositorio;

import com.gastos.controlgastosrest.modelos.IngresoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresoRepositorio extends JpaRepository<IngresoModelo, Integer> {
}
