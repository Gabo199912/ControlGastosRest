package com.gastos.controlgastosrest.DTO;

import java.math.BigDecimal;
import java.sql.Date;

public class EgresoFijoDTO {
    private Integer idCategoria;
    private Integer idUsurio;
    private String nombre;
    private BigDecimal monto;
    private Date fechaPago;
    private boolean pagado;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdUsurio() {
        return idUsurio;
    }

    public void setIdUsurio(Integer idUsurio) {
        this.idUsurio = idUsurio;
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
