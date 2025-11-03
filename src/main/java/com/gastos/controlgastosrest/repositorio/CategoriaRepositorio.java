package com.gastos.controlgastosrest.repositorio;

import com.gastos.controlgastosrest.modelos.CategoriaModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<CategoriaModelo, Integer> {
}
