package edu.bodega.yessy.back_sol.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`idproveedor`")
    private Integer idProveedor;
    @Column(name = "`persona_idpersona`")
    private Integer persona_idpersona;
    @Column (name = "`ruc`")
    private String RUC;
    @Column (name = "`descripcion`")
    private String descripcion;
    @Column (name = "`codigoUbigeo`")
    private String codigoUbigeo;
    @Column (name = "`direccion`")
    private String direccion;
    @Column (name = "`departamento`")
    private String departamento;
    @Column (name = "`ciudad`")
    private String ciudad;
    @Column (name = "`distrito`")
    private String distrito;
    @Column (name = "`codigoPostal`")
    private String codigoPostal;
    @Column (name = "`referenciaUbicacion`")
    private String referenciaUbicacion;
    @Column (name = "`correoEmpresa`")
    private String correoEmpresa;
    @Column (name = "`telefonoEmpresa`")
    private String telefonoEmpresa;
    @Column (name = "`telefonofijoEmpresa`")
    private String telefonofijoEmpresa;
    @Column (name = "`paginaWeb`")
    private String paginaWeb;
    @Column (name = "`nombreSectorista`")
    private String nombreSectorista;
    @Column (name = "`correoSectorista`")
    private String correoSectorista;
    @Column (name = "`celularSectorista`")
    private String celularSectorista;
    @Column (name = "`telefijoSectorista`")
    private String telefijoSectorista;
    @Column (name = "`etiquetas`")
    private String etiquetas;
    @Column (name = "`incidencias`")
    private String incidencias;
    @Column (name = "`fechaRegistro`")
    private LocalDateTime fechaRegistro;
    @Column (name = "`calificacion`")
    private String calificacion;
    @Column (name = "`condicionesPago`")
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
    public void setRUC(String RUC) {
        this.RUC = RUC;
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
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
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
}