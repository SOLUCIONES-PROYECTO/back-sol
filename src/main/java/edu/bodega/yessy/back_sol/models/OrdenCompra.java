package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden_compra")
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idordenCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_oc", nullable = false)
    private EstadoOrdenCompra estadoOc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @Column(name = "numero_orden", nullable = false, unique = true, length = 50)
    private String numeroOrden;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "fecha_entrega_esperada", nullable = false)
    private LocalDate fechaEntregaEsperada;

    @Column(name = "condiciones_pago", nullable = false)
    private String condicionesPago;

    @Column(name = "moneda", nullable = false, length = 10)
    private String moneda;

    @Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "igv", nullable = false, precision = 10, scale = 2)
    private BigDecimal igv;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleOrdenCompra> detalles = new ArrayList<>();

    public Integer getIdordenCompra() { return idordenCompra; }
    public void setIdordenCompra(Integer idordenCompra) { this.idordenCompra = idordenCompra; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }

    public EstadoOrdenCompra getEstadoOc() { return estadoOc; }
    public void setEstadoOc(EstadoOrdenCompra estadoOc) { this.estadoOc = estadoOc; }

    public MetodoPago getMetodoDePago() { return metodoPago; }
    public void setMetodoDePago(MetodoPago metodoDePago) { this.metodoPago = metodoDePago; }

    public String getNumeroOrden() { return numeroOrden; }
    public void setNumeroOrden(String numeroOrden) { this.numeroOrden = numeroOrden; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public LocalDate getFechaEntregaEsperada() { return fechaEntregaEsperada; }
    public void setFechaEntregaEsperada(LocalDate fechaEntregaEsperada) { this.fechaEntregaEsperada = fechaEntregaEsperada; }

    public String getCondicionesPago() { return condicionesPago; }
    public void setCondicionesPago(String condicionesPago) { this.condicionesPago = condicionesPago; }

    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }

    public BigDecimal getIgv() { return igv; }
    public void setIgv(BigDecimal igv) { this.igv = igv; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public List<DetalleOrdenCompra> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleOrdenCompra> detalles) { this.detalles = detalles; }
}
