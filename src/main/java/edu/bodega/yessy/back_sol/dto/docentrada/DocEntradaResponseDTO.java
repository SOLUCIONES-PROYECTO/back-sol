package edu.bodega.yessy.back_sol.dto.docentrada;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DocEntradaResponseDTO {

	private Integer iddocentrada;
	private Integer idTipoDocEntrada;
	private Integer idMetodoPago;
	private Integer idEstadoPago;
	private Integer idEstadoIngreso;
	private Integer idEmpleado;
	private Integer idProveedor;
	private String tipoDocEntrada;
	private String metodoPago;
	private String estadoPago;
	private String estadoIngreso;
	private String empleado;
	private String proveedor;
	private String numeroDocumento;
	private LocalDateTime fechaIngreso;
	private String incidencias;
	private BigDecimal precioTotal;

	public Integer getIddocentrada() {
		return iddocentrada;
	}

	public void setIddocentrada(Integer iddocentrada) {
		this.iddocentrada = iddocentrada;
	}

	public String getTipoDocEntrada() {
		return tipoDocEntrada;
	}

	public void setTipoDocEntrada(String tipoDocEntrada) {
		this.tipoDocEntrada = tipoDocEntrada;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(String estadoPago) {
		this.estadoPago = estadoPago;
	}

	public String getEstadoIngreso() {
		return estadoIngreso;
	}

	public void setEstadoIngreso(String estadoIngreso) {
		this.estadoIngreso = estadoIngreso;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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

	public Integer getIdTipoDocEntrada() {
		return idTipoDocEntrada;
	}

	public void setIdTipoDocEntrada(Integer idTipoDocEntrada) {
		this.idTipoDocEntrada = idTipoDocEntrada;
	}

	public Integer getIdMetodoPago() {
		return idMetodoPago;
	}

	public void setIdMetodoPago(Integer idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}

	public Integer getIdEstadoPago() {
		return idEstadoPago;
	}

	public void setIdEstadoPago(Integer idEstadoPago) {
		this.idEstadoPago = idEstadoPago;
	}

	public Integer getIdEstadoIngreso() {
		return idEstadoIngreso;
	}

	public void setIdEstadoIngreso(Integer idEstadoIngreso) {
		this.idEstadoIngreso = idEstadoIngreso;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	

}
