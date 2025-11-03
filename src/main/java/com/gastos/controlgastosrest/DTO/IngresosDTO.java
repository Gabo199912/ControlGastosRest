package com.gastos.controlgastosrest.DTO;

import com.gastos.controlgastosrest.modelos.CategoriaModelo;
import com.gastos.controlgastosrest.modelos.UsuariosModelo;

import java.math.BigDecimal;
import java.sql.Date;

public class IngresosDTO {
    private Integer idCategoria;
    private Integer idUsuario;
    private Date fecha;
    private String fuente;
    private BigDecimal monto;
    private String descripcion;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
