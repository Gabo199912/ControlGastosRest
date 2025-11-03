package com.gastos.controlgastosrest.servicios;

import com.gastos.controlgastosrest.modelos.GastoVariableModelo;
import com.gastos.controlgastosrest.repositorio.GastoVariableRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastoVariableServicio {
    private final GastoVariableRepositorio gastoVariableRepositorio;

    @Autowired
    public GastoVariableServicio(GastoVariableRepositorio gastoVariableRepositorio) {
        this.gastoVariableRepositorio = gastoVariableRepositorio;
    }

    public GastoVariableModelo guardarGastoVariable(GastoVariableModelo gastoVariable) {
        return gastoVariableRepositorio.save(gastoVariable);
    }
}
