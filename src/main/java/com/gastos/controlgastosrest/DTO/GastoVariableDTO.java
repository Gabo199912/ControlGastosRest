package com.gastos.controlgastosrest.DTO;


import com.gastos.controlgastosrest.modelos.CategoriaModelo;
import com.gastos.controlgastosrest.modelos.UsuariosModelo;

public class GastoVariableDTO {
    private UsuariosModelo idUsuario;
    private CategoriaModelo idCategoria;

    public UsuariosModelo getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuariosModelo idUsuario) {
        this.idUsuario = idUsuario;
    }

    public CategoriaModelo getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriaModelo idCategoria) {
        this.idCategoria = idCategoria;
    }
}
