package edu.bodega.yessy.back_sol.dto.docentrada;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DocEntradaRequestDTO {

	private Integer idTipoDocEntrada;
	private Integer idMetodoPago;
	private Integer idEstadoPago;
	private Integer idEstadoIngreso;
	private Integer idEmpleado;
	private Integer idProveedor;
	private String numeroDocumento;
	private LocalDateTime fechaIngreso;
	private String incidencias;
	private BigDecimal precioTotal;

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

}
