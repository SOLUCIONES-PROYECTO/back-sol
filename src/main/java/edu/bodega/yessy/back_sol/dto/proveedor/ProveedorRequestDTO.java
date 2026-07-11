package edu.bodega.yessy.back_sol.dto.proveedor;

import java.time.LocalDateTime;

public class ProveedorRequestDTO {

	private Integer idProveedor;
	private Integer idPersona;
	private String ruc;
	private String descripcion;
	private String codigoUbigeo;
	private String direccion;
	private String departamento;
	private String ciudad;
	private String distrito;
	private String codigoPostal;
	private String referenciaUbicacion;
	private String correoEmpresa;
	private String telefonoEmpresa;
	private String telefonoFijoEmpresa;
	private String paginaWeb;
	private String nombreSectorista;
	private String correoSectorista;
	private String celularSectorista;
	private String telefonoFijoSectorista;
	private String etiquetas;
	private String incidencias;
	private String condicionesPago;
	private String calificacion;
	private LocalDateTime fechaRegistro;

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigoUbigeo() {
		return codigoUbigeo;
	}

	public void setCodigoUbigeo(String codigoUbigeo) {
		this.codigoUbigeo = codigoUbigeo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getReferenciaUbicacion() {
		return referenciaUbicacion;
	}

	public void setReferenciaUbicacion(String referenciaUbicacion) {
		this.referenciaUbicacion = referenciaUbicacion;
	}

	public String getCorreoEmpresa() {
		return correoEmpresa;
	}

	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}

	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}

	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}

	public String getTelefonoFijoEmpresa() {
		return telefonoFijoEmpresa;
	}

	public void setTelefonoFijoEmpresa(String telefonoFijoEmpresa) {
		this.telefonoFijoEmpresa = telefonoFijoEmpresa;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getNombreSectorista() {
		return nombreSectorista;
	}

	public void setNombreSectorista(String nombreSectorista) {
		this.nombreSectorista = nombreSectorista;
	}

	public String getCorreoSectorista() {
		return correoSectorista;
	}

	public void setCorreoSectorista(String correoSectorista) {
		this.correoSectorista = correoSectorista;
	}

	public String getCelularSectorista() {
		return celularSectorista;
	}

	public void setCelularSectorista(String celularSectorista) {
		this.celularSectorista = celularSectorista;
	}

	public String getTelefonoFijoSectorista() {
		return telefonoFijoSectorista;
	}

	public void setTelefonoFijoSectorista(String telefonoFijoSectorista) {
		this.telefonoFijoSectorista = telefonoFijoSectorista;
	}

	public String getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}

	public String getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(String incidencias) {
		this.incidencias = incidencias;
	}

	public String getCondicionesPago() {
		return condicionesPago;
	}

	public void setCondicionesPago(String condicionesPago) {
		this.condicionesPago = condicionesPago;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
