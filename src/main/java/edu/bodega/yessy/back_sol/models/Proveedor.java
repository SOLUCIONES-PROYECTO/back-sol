package edu.bodega.yessy.back_sol.models;

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
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @Column (name = "ruc", nullable = false, unique = true, length = 11)
    private String ruc;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "codigo_ubigeo", nullable = false)
    private String codigoUbigeo;

    @Column (name = "direccion", nullable = false)
    private String direccion;

    @Column (name = "departamento", nullable = false)
    private String departamento;

    @Column (name = "ciudad", nullable = false)
    private String ciudad;

    @Column (name = "distrito", nullable = false)
    private String distrito;

    @Column (name = "codigo_postal", nullable = false)
    private String codigoPostal;

    @Column (name = "referencia_ubicacion")
    private String referenciaUbicacion;

    @Column (name = "correo_empresa", nullable = false)
    private String correoEmpresa;

    @Column (name = "telefono_empresa", nullable = false)
    private String telefonoEmpresa;

    @Column (name = "telefono_fijo_empresa")
    private String telefonoFijoEmpresa;

    @Column (name = "pagina_web")
    private String paginaWeb;

    @Column (name = "nombre_sectorista", nullable = false)
    private String nombreSectorista;

    @Column (name = "correo_sectorista", nullable = false)
    private String correoSectorista;

    @Column (name = "celular_sectorista", nullable = false)
    private String celularSectorista;

    @Column (name = "telefono_fijo_sectorista")
    private String telefonoFijoSectorista;

    @Column (name = "etiquetas")
    private String etiquetas;

    @Column (name = "incidencias")
    private String incidencias;

    @Column (name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column (name = "calificacion")
    private String calificacion;
    
    @Column (name = "condiciones_pago", nullable = false)
    private String condicionesPago;

    public Integer getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getRUC() {
        return ruc;
    }
    public void setRUC(String ruc) {
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