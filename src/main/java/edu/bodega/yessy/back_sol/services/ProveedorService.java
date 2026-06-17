package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Persona persona = personaRepository
                .findById(dto.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Proveedor proveedor = new Proveedor();

        proveedor.setPersona(persona);
        proveedor.setRUC(dto.getRuc());
        proveedor.setDescripcion(dto.getDescripcion());
        proveedor.setCodigoUbigeo(dto.getCodigoUbigeo());
        proveedor.setDireccion(dto.getDireccion());
        proveedor.setDepartamento(dto.getDepartamento());
        proveedor.setCiudad(dto.getCiudad());
        proveedor.setDistrito(dto.getDistrito());
        proveedor.setCodigoPostal(dto.getCodigoPostal());
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
        proveedor.setCondicionesPago(dto.getCondicionesPago());
        proveedor.setCalificacion(dto.getCalificacion());
        proveedor.setFechaRegistro(dto.getFechaRegistro());

        Proveedor guardado = proveedorRepository.save(proveedor);

        return convertirDTO(guardado);
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

        Persona persona = personaRepository
                .findById(dto.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        proveedor.setPersona(persona);
        proveedor.setRUC(dto.getRuc());
        proveedor.setDescripcion(dto.getDescripcion());
        proveedor.setCodigoUbigeo(dto.getCodigoUbigeo());
        proveedor.setDireccion(dto.getDireccion());
        proveedor.setDepartamento(dto.getDepartamento());
        proveedor.setCiudad(dto.getCiudad());
        proveedor.setDistrito(dto.getDistrito());
        proveedor.setCodigoPostal(dto.getCodigoPostal());
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
        proveedor.setCondicionesPago(dto.getCondicionesPago());
        proveedor.setCalificacion(dto.getCalificacion());
        proveedor.setFechaRegistro(dto.getFechaRegistro());

        Proveedor actualizado = proveedorRepository.save(proveedor);

        return convertirDTO(actualizado);
    }

    public void eliminar(Integer id) {
        Proveedor proveedor = proveedorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        proveedorRepository.delete(proveedor);
    }

    private ProveedorResponseDTO convertirDTO(Proveedor proveedor) {
        ProveedorResponseDTO dto = new ProveedorResponseDTO();

        dto.setIdProveedor(proveedor.getIdProveedor());
        dto.setIdPersona(proveedor.getPersona().getIdpersona());
        dto.setNombre(proveedor.getPersona().getNombre());
        dto.setApellido(proveedor.getPersona().getApellido());
        dto.setRuc(proveedor.getRUC());
        dto.setDescripcion(proveedor.getDescripcion());
        dto.setDireccion(proveedor.getDireccion());
        dto.setDepartamento(proveedor.getDepartamento());
        dto.setCiudad(proveedor.getCiudad());
        dto.setDistrito(proveedor.getDistrito());
        dto.setCodigoPostal(proveedor.getCodigoPostal());
        dto.setCorreoEmpresa(proveedor.getCorreoEmpresa());
        dto.setTelefonoEmpresa(proveedor.getTelefonoEmpresa());
        dto.setPaginaWeb(proveedor.getPaginaWeb());
        dto.setNombreSectorista(proveedor.getNombreSectorista());
        dto.setCorreoSectorista(proveedor.getCorreoSectorista());
        dto.setCelularSectorista(proveedor.getCelularSectorista());
        dto.setCondicionesPago(proveedor.getCondicionesPago());
        dto.setCalificacion(proveedor.getCalificacion());
        dto.setFechaRegistro(proveedor.getFechaRegistro());

        return dto;
    }

}
