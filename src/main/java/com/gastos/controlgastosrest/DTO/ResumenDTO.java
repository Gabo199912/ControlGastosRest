package com.gastos.controlgastosrest.DTO;

import java.math.BigDecimal;

public class ResumenDTO {
    private BigDecimal totalIngresos;
    private BigDecimal totalEgresosFijos;
    private BigDecimal saldoRestante;
    private BigDecimal ahorroRecomendado;

    public ResumenDTO(BigDecimal ingresos, BigDecimal egresos, BigDecimal porcentaje) {
        this.totalIngresos = ingresos;
        this.totalEgresosFijos = egresos;
        this.saldoRestante = ingresos.subtract(egresos);

        this.ahorroRecomendado = saldoRestante.multiply(porcentaje)
                .divide(new BigDecimal("100"));
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

    public BigDecimal getSaldoRestante() {
        return saldoRestante;
    }

    public void setSaldoRestante(BigDecimal saldoRestante) {
        this.saldoRestante = saldoRestante;
    }

    public BigDecimal getAhorroRecomendado() {
        return ahorroRecomendado;
    }

    public void setAhorroRecomendado(BigDecimal ahorroRecomendado) {
        this.ahorroRecomendado = ahorroRecomendado;
    }
}
