package edu.bodega.yessy.back_sol.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    private Integer idProveedor;

    private Integer persona_idpersona;
    private String RUC;
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
    private String telefonofijoEmpresa;
    private String paginaWeb;
    private String nombreSectorista;
    private String correoSectorista;
    private String celularSectorista;
    private String telefijoSectorista;
    private String etiquetas;
    private String incidencias;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    private String calificacion;
    private String condicionesPago;
    public Integer getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    public Integer getPersona_idpersona() {
        return persona_idpersona;
    }
    public void setPersona_idpersona(Integer persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    }
    public String getRUC() {
        return RUC;
    }
    public void setRUC(String rUC) {
        RUC = rUC;
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
    public String getTelefonofijoEmpresa() {
        return telefonofijoEmpresa;
    }
    public void setTelefonofijoEmpresa(String telefonofijoEmpresa) {
        this.telefonofijoEmpresa = telefonofijoEmpresa;
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
    public String getTelefijoSectorista() {
        return telefijoSectorista;
    }
    public void setTelefijoSectorista(String telefijoSectorista) {
        this.telefijoSectorista = telefijoSectorista;
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
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
    public String getCondicionesPago() {
        return condicionesPago;
    }
    public void setCondicionesPago(String condicionesPago) {
        this.condicionesPago = condicionesPago;
    }

    // Getters y Setters
    
}
