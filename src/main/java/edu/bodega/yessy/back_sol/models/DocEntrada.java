package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doc_entrada")
public class DocEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocentrada;

    @ManyToOne
    @JoinColumn(name = "id_tipo_doc_entrada", nullable = false)
    private TipoDocEntrada tipoDocEntrada;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_estado_pago", nullable = false)
    private EstadoPago estadoPago;

    @ManyToOne
    @JoinColumn(name = "id_estado_ingreso", nullable = false)
    private EstadoIngreso estadoIngreso;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_Proveedor", nullable = false)
    private Proveedor proveedor;

    @Column(name = "numero_documento", nullable = false)
    private String numeroDocumento;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDateTime fecha_ingreso;

    @Column(name = "incidencias")
    private String incidencias;

    @Column(name = "precio_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioTotal;

    public Integer getIddocentrada() {
        return iddocentrada;
    }

    public void setIddocentrada(Integer iddocentrada) {
        this.iddocentrada = iddocentrada;
    }

    public TipoDocEntrada getTipoDocEntrada() {
        return tipoDocEntrada;
    }

    public void setTipoDocEntrada(TipoDocEntrada tipoDocEntrada) {
        this.tipoDocEntrada = tipoDocEntrada;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public EstadoIngreso getEstadoIngreso() {
        return estadoIngreso;
    }

    public void setEstadoIngreso(EstadoIngreso estadoIngreso) {
        this.estadoIngreso = estadoIngreso;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDateTime getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDateTime fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    
}
