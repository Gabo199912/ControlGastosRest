package com.gastos.controlgastosrest.modelos;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "egreso_fijo")
public class EgresoFijoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_egreso_fijo")
    private Integer idEgresoFijo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuariosModelo usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaModelo categoria;

    private String nombre;
    private BigDecimal monto;

    @Column(name = "fecha_pago")
    private Date fechaPago;

    private boolean pagado;

    public Integer getIdEgresoFijo() {
        return idEgresoFijo;
    }

    public void setIdEgresoFijo(Integer idEgresoFijo) {
        this.idEgresoFijo = idEgresoFijo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
}
