package com.gastos.controlgastosrest.servicios;

import com.gastos.controlgastosrest.DTO.ResumenDTO;
import com.gastos.controlgastosrest.repositorio.EgresoFijoRepositorio;
import com.gastos.controlgastosrest.repositorio.IngresoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ResumenServicio {


    @Autowired
    private IngresoRepositorio ingresoRepositorio;

    @Autowired
    private EgresoFijoRepositorio egresoFijoRepositorio;

    public ResumenDTO obtenerResumenPorUsuario(Integer idUsuario, BigDecimal porcentajeAhorro) {

        BigDecimal totalIngresos =
                ingresoRepositorio.totalIngresosPorUsuario(idUsuario);

        BigDecimal totalEgresos =
                egresoFijoRepositorio.totalEgresosFijosPorUsuario(idUsuario);

        return new ResumenDTO(totalIngresos, totalEgresos, porcentajeAhorro);
    }
}
