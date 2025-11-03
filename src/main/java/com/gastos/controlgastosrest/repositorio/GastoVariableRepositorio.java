package com.gastos.controlgastosrest.repositorio;

import com.gastos.controlgastosrest.modelos.GastoVariableModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoVariableRepositorio extends JpaRepository<GastoVariableModelo, Integer> {
}
