package edu.bodega.yessy.back_sol.dto.dashboard;

import java.time.LocalDate;

public class ProductoVencimientoDTO {
    private Integer idProducto;
    private String nombreProducto;
    private String categoria;
    private Integer stockActual;
    private LocalDate fechaVencimiento;
    private Long diasRestantes;
    private String urgencia; // "VENCIDO", "URGENTE", "PROXIMO", "ADVERTENCIA"

    public ProductoVencimientoDTO(Integer idProducto, String nombreProducto,
            String categoria, Integer stockActual,
            LocalDate fechaVencimiento, Long diasRestantes, String urgencia) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.stockActual = stockActual;
        this.fechaVencimiento = fechaVencimiento;
        this.diasRestantes = diasRestantes;
        this.urgencia = urgencia;
    }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Integer getStockActual() { return stockActual; }
    public void setStockActual(Integer stockActual) { this.stockActual = stockActual; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public Long getDiasRestantes() { return diasRestantes; }
    public void setDiasRestantes(Long diasRestantes) { this.diasRestantes = diasRestantes; }

    public String getUrgencia() { return urgencia; }
    public void setUrgencia(String urgencia) { this.urgencia = urgencia; }
}
