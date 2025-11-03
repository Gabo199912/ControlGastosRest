package com.gastos.controlgastosrest.modelos;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "resumen_mensual")
public class ResumenMensualModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resumen")
    private Integer idResumen;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuariosModelo usuario;

    private Integer mes;
    private Integer anio;

    @Column(name = "total_ingresos")
    private BigDecimal totalIngresos = BigDecimal.ZERO;

    @Column(name = "total_egresos_fijos")
    private BigDecimal totalEgresosFijos = BigDecimal.ZERO;

    @Column(name = "total_gastos_variables")
    private BigDecimal totalGastosVariables = BigDecimal.ZERO;

    @Column(name = "saldo_restante")
    private BigDecimal saldoRestante = BigDecimal.ZERO;

    public Integer getIdResumen() {
        return idResumen;
    }

    public void setIdResumen(Integer idResumen) {
        this.idResumen = idResumen;
    }

    public UsuariosModelo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosModelo usuario) {
        this.usuario = usuario;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public BigDecimal getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(BigDecimal totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public BigDecimal getTotalEgresosFijos() {
        return totalEgresosFijos;
    }

    public void setTotalEgresosFijos(BigDecimal totalEgresosFijos) {
        this.totalEgresosFijos = totalEgresosFijos;
    }

    public BigDecimal getTotalGastosVariables() {
        return totalGastosVariables;
    }

    public void setTotalGastosVariables(BigDecimal totalGastosVariables) {
        this.totalGastosVariables = totalGastosVariables;
    }

    public BigDecimal getSaldoRestante() {
        return saldoRestante;
    }

    public void setSaldoRestante(BigDecimal saldoRestante) {
        this.saldoRestante = saldoRestante;
    }
}
