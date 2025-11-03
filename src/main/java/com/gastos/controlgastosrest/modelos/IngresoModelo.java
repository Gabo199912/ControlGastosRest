package com.gastos.controlgastosrest.modelos;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ingreso")
public class IngresoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso")
    private Integer idIngreso;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuariosModelo usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaModelo categoria;

    private Date fecha;
    private String fuente;
    private BigDecimal monto;
    private String descripcion;

    public Integer getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(Integer idIngreso) {
        this.idIngreso = idIngreso;
    }

    public UsuariosModelo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosModelo usuario) {
        this.usuario = usuario;
    }

    public CategoriaModelo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModelo categoria) {
        this.categoria = categoria;
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
