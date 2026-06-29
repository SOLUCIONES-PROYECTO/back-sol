package edu.bodega.yessy.back_sol.dto.dashboard;

import java.math.BigDecimal;

public class ResumenDashboardDTO {
    private BigDecimal ingresosTotales;
    private BigDecimal comprasTotales;
    private BigDecimal gananciaTotal;
    private Long cantidadVentas;

    public BigDecimal getIngresosTotales() { return ingresosTotales; }
    public void setIngresosTotales(BigDecimal ingresosTotales) { this.ingresosTotales = ingresosTotales; }

    public BigDecimal getComprasTotales() { return comprasTotales; }
    public void setComprasTotales(BigDecimal comprasTotales) { this.comprasTotales = comprasTotales; }

    public BigDecimal getGananciaTotal() { return gananciaTotal; }
    public void setGananciaTotal(BigDecimal gananciaTotal) { this.gananciaTotal = gananciaTotal; }

    public Long getCantidadVentas() { return cantidadVentas; }
    public void setCantidadVentas(Long cantidadVentas) { this.cantidadVentas = cantidadVentas; }
}

