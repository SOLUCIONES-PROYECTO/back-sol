package edu.bodega.yessy.back_sol.dto.dashboard;

import java.math.BigDecimal;

public class VentaMesDTO {
    private String mes; // formato "2026-06"
    private BigDecimal total;

    public VentaMesDTO(String mes, BigDecimal total) {
        this.mes = mes;
        this.total = total;
    }

    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
