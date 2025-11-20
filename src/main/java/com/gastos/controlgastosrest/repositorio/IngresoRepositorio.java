package com.gastos.controlgastosrest.repositorio;

import com.gastos.controlgastosrest.modelos.IngresoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngresoRepositorio extends JpaRepository<IngresoModelo, Integer> {
    List<IngresoModelo> findByUsuario_IdUsuario(Integer idUsuario);
    @Query("SELECT COALESCE(SUM(i.monto), 0) FROM IngresoModelo i WHERE i.usuario.idUsuario = :idUsuario")
    BigDecimal totalIngresosPorUsuario(Integer idUsuario);
}
