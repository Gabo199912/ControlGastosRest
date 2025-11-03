package com.gastos.controlgastosrest.modelos;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "gasto_variable")
public class GastoVariableModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gasto")
    private Integer idGasto;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuariosModelo usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaModelo categoria;

    private BigDecimal monto;
    private Date fecha;

    @Column(name = "metodo_pago")
    private String metodoPago;

    private String descripcion;

    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
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

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
