package edu.bodega.yessy.back_sol.dto.dashboard;

public class TendenciaProductoDTO {

    private Integer idProducto;
    private String nombreProducto;
    private Long cantidadMesActual;
    private Long cantidadMesAnterior;
    private String tendencia; // "Alza", "Baja", "Estable"
    private Double variacionPorcentual; // null si no se puede calcular

    public TendenciaProductoDTO(Integer idProducto, String nombreProducto, Long cantidadMesActual,
                                 Long cantidadMesAnterior, String tendencia, Double variacionPorcentual) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadMesActual = cantidadMesActual;
        this.cantidadMesAnterior = cantidadMesAnterior;
        this.tendencia = tendencia;
        this.variacionPorcentual = variacionPorcentual;
    }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public Long getCantidadMesActual() { return cantidadMesActual; }
    public void setCantidadMesActual(Long cantidadMesActual) { this.cantidadMesActual = cantidadMesActual; }

    public Long getCantidadMesAnterior() { return cantidadMesAnterior; }
    public void setCantidadMesAnterior(Long cantidadMesAnterior) { this.cantidadMesAnterior = cantidadMesAnterior; }

    public String getTendencia() { return tendencia; }
    public void setTendencia(String tendencia) { this.tendencia = tendencia; }

    public Double getVariacionPorcentual() { return variacionPorcentual; }
    public void setVariacionPorcentual(Double variacionPorcentual) { this.variacionPorcentual = variacionPorcentual; }
}