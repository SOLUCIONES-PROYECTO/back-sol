package edu.bodega.yessy.back_sol.dto.dashboard;

import java.math.BigDecimal;

public class GananciaMesDTO {
    private String mes;
    private BigDecimal ingresos;
    private BigDecimal compras;
    private BigDecimal ganancia;

    public GananciaMesDTO(String mes, BigDecimal ingresos, BigDecimal compras, BigDecimal ganancia) {
        this.mes = mes;
        this.ingresos = ingresos;
        this.compras = compras;
        this.ganancia = ganancia;
    }

    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }

    public BigDecimal getIngresos() { return ingresos; }
    public void setIngresos(BigDecimal ingresos) { this.ingresos = ingresos; }

    public BigDecimal getCompras() { return compras; }
    public void setCompras(BigDecimal compras) { this.compras = compras; }

    public BigDecimal getGanancia() { return ganancia; }
    public void setGanancia(BigDecimal ganancia) { this.ganancia = ganancia; }
}
