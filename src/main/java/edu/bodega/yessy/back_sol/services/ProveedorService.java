package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.bodega.yessy.back_sol.dto.proveedor.ProveedorRequestDTO;
import edu.bodega.yessy.back_sol.dto.proveedor.ProveedorResponseDTO;
import edu.bodega.yessy.back_sol.models.Persona;
import edu.bodega.yessy.back_sol.models.Proveedor;
import edu.bodega.yessy.back_sol.repositories.PersonaRepository;
import edu.bodega.yessy.back_sol.repositories.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public ArrayList<ProveedorResponseDTO> listar() {
        ArrayList<ProveedorResponseDTO> lista = new ArrayList<>();

        for (Proveedor proveedor : proveedorRepository.findAll()) {
            lista.add(convertirDTO(proveedor));
        }

        return lista;
    }

    public ProveedorResponseDTO nuevo(ProveedorRequestDTO dto) {
        if (proveedorRepository.existsByRuc(dto.getRuc())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El RUC ya está registrado");
        }

        Persona persona = obtenerPersonaCentinela();
        Proveedor proveedor = new Proveedor();

        proveedor.setPersona(persona);
        proveedor.setRUC(dto.getRuc());
        proveedor.setDescripcion(dto.getDescripcion());
        proveedor.setCodigoUbigeo(dto.getCodigoUbigeo() != null ? dto.getCodigoUbigeo() : "");
        proveedor.setDireccion(dto.getDireccion());
        proveedor.setDepartamento(dto.getDepartamento());
        proveedor.setCiudad(dto.getCiudad());
        proveedor.setDistrito(dto.getDistrito());
        proveedor.setCodigoPostal(dto.getCodigoPostal() != null ? dto.getCodigoPostal() : "");
        proveedor.setReferenciaUbicacion(dto.getReferenciaUbicacion());
        proveedor.setCorreoEmpresa(dto.getCorreoEmpresa());
        proveedor.setTelefonoEmpresa(dto.getTelefonoEmpresa());
        proveedor.setTelefonoFijoEmpresa(dto.getTelefonoFijoEmpresa());
        proveedor.setPaginaWeb(dto.getPaginaWeb());
        proveedor.setNombreSectorista(dto.getNombreSectorista());
        proveedor.setCorreoSectorista(dto.getCorreoSectorista());
        proveedor.setCelularSectorista(dto.getCelularSectorista());
        proveedor.setTelefonoFijoSectorista(dto.getTelefonoFijoSectorista());
        proveedor.setEtiquetas(dto.getEtiquetas());
        proveedor.setIncidencias(dto.getIncidencias());
        proveedor.setCondicionesPago(dto.getCondicionesPago() != null ? dto.getCondicionesPago() : "");
        proveedor.setCalificacion(dto.getCalificacion() != null ? dto.getCalificacion() : "");
        proveedor.setFechaRegistro(java.time.LocalDateTime.now()); // 👈 siempre automático

        return convertirDTO(proveedorRepository.save(proveedor));
    }

    public ProveedorResponseDTO buscar(Integer id) {
        Proveedor proveedor = proveedorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        return convertirDTO(proveedor);
    }

    public ProveedorResponseDTO actualizar(Integer id, ProveedorRequestDTO dto) {

        Proveedor proveedor = proveedorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        boolean rucCambio = !proveedor.getRUC().equals(dto.getRuc());
        if (rucCambio && proveedorRepository.existsByRuc(dto.getRuc())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El RUC ya está registrado");
        }

        proveedor.setRUC(dto.getRuc());
        proveedor.setDescripcion(dto.getDescripcion());
        proveedor.setCodigoUbigeo(dto.getCodigoUbigeo() != null ? dto.getCodigoUbigeo() : "");
        proveedor.setDireccion(dto.getDireccion());
        proveedor.setDepartamento(dto.getDepartamento());
        proveedor.setCiudad(dto.getCiudad());
        proveedor.setDistrito(dto.getDistrito());
        proveedor.setCodigoPostal(dto.getCodigoPostal() != null ? dto.getCodigoPostal() : "");
        proveedor.setReferenciaUbicacion(dto.getReferenciaUbicacion());
        proveedor.setCorreoEmpresa(dto.getCorreoEmpresa());
        proveedor.setTelefonoEmpresa(dto.getTelefonoEmpresa());
        proveedor.setTelefonoFijoEmpresa(dto.getTelefonoFijoEmpresa());
        proveedor.setPaginaWeb(dto.getPaginaWeb());
        proveedor.setNombreSectorista(dto.getNombreSectorista());
        proveedor.setCorreoSectorista(dto.getCorreoSectorista());
        proveedor.setCelularSectorista(dto.getCelularSectorista());
        proveedor.setTelefonoFijoSectorista(dto.getTelefonoFijoSectorista());
        proveedor.setEtiquetas(dto.getEtiquetas());
        proveedor.setIncidencias(dto.getIncidencias());
        proveedor.setCondicionesPago(dto.getCondicionesPago() != null ? dto.getCondicionesPago() : "");
        proveedor.setCalificacion(dto.getCalificacion() != null ? dto.getCalificacion() : "");
        // fechaRegistro no se actualiza — conserva la fecha original de creación

        return convertirDTO(proveedorRepository.save(proveedor));
    }

    public void eliminar(Integer id) {
        Proveedor proveedor = proveedorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        proveedorRepository.delete(proveedor);
    }

    // ================= convertirDTO — agrega los campos nuevos =================
    private ProveedorResponseDTO convertirDTO(Proveedor proveedor) {
        ProveedorResponseDTO dto = new ProveedorResponseDTO();

        dto.setIdProveedor(proveedor.getIdProveedor());
        dto.setIdPersona(proveedor.getPersona().getIdpersona());
        dto.setNombre(proveedor.getPersona().getNombre());
        dto.setApellido(proveedor.getPersona().getApellido());
        dto.setRuc(proveedor.getRUC());
        dto.setDescripcion(proveedor.getDescripcion());
        dto.setCodigoUbigeo(proveedor.getCodigoUbigeo());
        dto.setDireccion(proveedor.getDireccion());
        dto.setDepartamento(proveedor.getDepartamento());
        dto.setCiudad(proveedor.getCiudad());
        dto.setDistrito(proveedor.getDistrito());
        dto.setCodigoPostal(proveedor.getCodigoPostal());
        dto.setReferenciaUbicacion(proveedor.getReferenciaUbicacion());
        dto.setCorreoEmpresa(proveedor.getCorreoEmpresa());
        dto.setTelefonoEmpresa(proveedor.getTelefonoEmpresa());
        dto.setTelefonoFijoEmpresa(proveedor.getTelefonoFijoEmpresa());
        dto.setPaginaWeb(proveedor.getPaginaWeb());
        dto.setNombreSectorista(proveedor.getNombreSectorista());
        dto.setCorreoSectorista(proveedor.getCorreoSectorista());
        dto.setCelularSectorista(proveedor.getCelularSectorista());
        dto.setTelefonoFijoSectorista(proveedor.getTelefonoFijoSectorista());
        dto.setEtiquetas(proveedor.getEtiquetas());
        dto.setIncidencias(proveedor.getIncidencias());
        dto.setCondicionesPago(proveedor.getCondicionesPago());
        dto.setCalificacion(proveedor.getCalificacion());
        dto.setFechaRegistro(proveedor.getFechaRegistro());

        return dto;
    }

    // ================= HELPER: obtener persona centinela =================
    private Persona obtenerPersonaCentinela() {
        final String dniCentinela = "00000001"; // distinto al de cliente (00000000)

        return personaRepository.findByDni(dniCentinela)
                .orElseGet(() -> {
                    Persona nueva = new Persona();
                    nueva.setNombre("Empresa");
                    nueva.setApellido("Proveedora");
                    nueva.setDni(dniCentinela);
                    nueva.setFechaRegistro(java.time.LocalDateTime.now());
                    return personaRepository.save(nueva);
                });
    }

}
