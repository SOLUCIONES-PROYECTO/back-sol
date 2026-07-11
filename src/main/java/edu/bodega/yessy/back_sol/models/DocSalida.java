package edu.bodega.yessy.back_sol.models;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "doc_salida")
public class DocSalida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocsalida;

    @ManyToOne
    @JoinColumn(name = "id_tipo_doc_salida", nullable = false)
    private TipoDocSalida tipoDocSalida;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @Column(name = "numero_documento", nullable = false)
    private String numeroDocumento;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_egreso", nullable = false)
    private LocalDate fechaEgreso;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "total_salida", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalSalida;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getIddocsalida() {
        return iddocsalida;
    }

    public void setIddocsalida(Integer iddocsalida) {
        this.iddocsalida = iddocsalida;
    }

    public TipoDocSalida getTipoDocSalida() {
        return tipoDocSalida;
    }

    public void setTipoDocSalida(TipoDocSalida tipoDocSalida) {
        this.tipoDocSalida = tipoDocSalida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTotalSalida() {
        return totalSalida;
    }

    public void setTotalSalida(BigDecimal totalSalida) {
        this.totalSalida = totalSalida;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

}
