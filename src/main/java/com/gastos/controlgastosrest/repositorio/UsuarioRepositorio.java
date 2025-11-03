package com.gastos.controlgastosrest.repositorio;

import com.gastos.controlgastosrest.modelos.UsuariosModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuariosModelo, Integer> {
    UsuariosModelo findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
