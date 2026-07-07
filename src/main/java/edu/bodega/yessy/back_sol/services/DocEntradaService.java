package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.docentrada.DocEntradaRequestDTO;
import edu.bodega.yessy.back_sol.dto.docentrada.DocEntradaResponseDTO;
import edu.bodega.yessy.back_sol.models.DocEntrada;
import edu.bodega.yessy.back_sol.models.Empleado;
import edu.bodega.yessy.back_sol.models.EstadoIngreso;
import edu.bodega.yessy.back_sol.models.EstadoPago;
import edu.bodega.yessy.back_sol.models.MetodoPago;
import edu.bodega.yessy.back_sol.models.Proveedor;
import edu.bodega.yessy.back_sol.models.TipoDocEntrada;
import edu.bodega.yessy.back_sol.repositories.DocEntradaRepository;
import edu.bodega.yessy.back_sol.repositories.EmpleadoRepository;
import edu.bodega.yessy.back_sol.repositories.EstadoIngresoRepository;
import edu.bodega.yessy.back_sol.repositories.EstadoPagoRepository;
import edu.bodega.yessy.back_sol.repositories.MetodoPagoRepository;
import edu.bodega.yessy.back_sol.repositories.ProveedorRepository;
import edu.bodega.yessy.back_sol.repositories.TipoDocEntradaRepository;

@Service
public class DocEntradaService {

    @Autowired
    private DocEntradaRepository docEntradaRepository;

    @Autowired
    private TipoDocEntradaRepository tipoDocEntradaRepository;

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Autowired
    private EstadoPagoRepository estadoPagoRepository;

    @Autowired
    private EstadoIngresoRepository estadoIngresoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    public ArrayList<DocEntradaResponseDTO> listar() {
    ArrayList<DocEntradaResponseDTO> lista = new ArrayList<>();

    for (DocEntrada docEntrada : docEntradaRepository.findAll()) {
        lista.add(convertirDTO(docEntrada));
    }

    return lista;
    }

    public DocEntradaResponseDTO nuevo(DocEntradaRequestDTO dto) {
    TipoDocEntrada tipo = tipoDocEntradaRepository
        .findById(dto.getIdTipoDocEntrada())
        .orElseThrow(() -> new RuntimeException("Tipo de documento de entrada no encontrado"));

    MetodoPago metodo = metodoPagoRepository
        .findById(dto.getIdMetodoPago())
        .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

    EstadoPago estadoPago = estadoPagoRepository
        .findById(dto.getIdEstadoPago())
        .orElseThrow(() -> new RuntimeException("Estado de pago no encontrado"));

    EstadoIngreso estadoIngreso = estadoIngresoRepository
        .findById(dto.getIdEstadoIngreso())
        .orElseThrow(() -> new RuntimeException("Estado de ingreso no encontrado"));

    Empleado empleado = empleadoRepository
        .findById(dto.getIdEmpleado())
        .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

    Proveedor proveedor = proveedorRepository
        .findById(dto.getIdProveedor())
        .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

    DocEntrada docEntrada = new DocEntrada();

    docEntrada.setTipoDocEntrada(tipo);
    docEntrada.setMetodoPago(metodo);
    docEntrada.setEstadoPago(estadoPago);
    docEntrada.setEstadoIngreso(estadoIngreso);
    docEntrada.setEmpleado(empleado);
    docEntrada.setProveedor(proveedor);
    docEntrada.setNumeroDocumento(generarNumeroDocumento(tipo));
    docEntrada.setFecha_ingreso(dto.getFechaIngreso());
    docEntrada.setIncidencias(dto.getIncidencias());
    docEntrada.setPrecioTotal(dto.getPrecioTotal());

    DocEntrada guardado = docEntradaRepository.save(docEntrada);

    return convertirDTO(guardado);
    }

    public DocEntradaResponseDTO buscar(Integer id) {
    DocEntrada docEntrada = docEntradaRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("DocEntrada no encontrado"));

    return convertirDTO(docEntrada);
    }

    public DocEntradaResponseDTO actualizar(Integer id, DocEntradaRequestDTO dto) {
    DocEntrada docEntrada = docEntradaRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("DocEntrada no encontrado"));

    TipoDocEntrada tipo = tipoDocEntradaRepository
        .findById(dto.getIdTipoDocEntrada())
        .orElseThrow(() -> new RuntimeException("Tipo de documento de entrada no encontrado"));

    MetodoPago metodo = metodoPagoRepository
        .findById(dto.getIdMetodoPago())
        .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

    EstadoPago estadoPago = estadoPagoRepository
        .findById(dto.getIdEstadoPago())
        .orElseThrow(() -> new RuntimeException("Estado de pago no encontrado"));

    EstadoIngreso estadoIngreso = estadoIngresoRepository
        .findById(dto.getIdEstadoIngreso())
        .orElseThrow(() -> new RuntimeException("Estado de ingreso no encontrado"));

    Empleado empleado = empleadoRepository
        .findById(dto.getIdEmpleado())
        .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

    Proveedor proveedor = proveedorRepository
        .findById(dto.getIdProveedor())
        .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

    docEntrada.setTipoDocEntrada(tipo);
    docEntrada.setMetodoPago(metodo);
    docEntrada.setEstadoPago(estadoPago);
    docEntrada.setEstadoIngreso(estadoIngreso);
    docEntrada.setEmpleado(empleado);
    docEntrada.setProveedor(proveedor);
    docEntrada.setNumeroDocumento(dto.getNumeroDocumento());
    docEntrada.setFecha_ingreso(dto.getFechaIngreso());
    docEntrada.setIncidencias(dto.getIncidencias());
    docEntrada.setPrecioTotal(dto.getPrecioTotal());

    DocEntrada actualizado = docEntradaRepository.save(docEntrada);

    return convertirDTO(actualizado);
    }

    public void eliminar(Integer id) {
    DocEntrada docEntrada = docEntradaRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("DocEntrada no encontrado"));

    docEntradaRepository.delete(docEntrada);
    }

    private DocEntradaResponseDTO convertirDTO(DocEntrada docEntrada) {
    DocEntradaResponseDTO dto = new DocEntradaResponseDTO();

    dto.setIddocentrada(docEntrada.getIddocentrada());
    dto.setIdTipoDocEntrada(docEntrada.getTipoDocEntrada().getIdtipodocentrada());
    dto.setTipoDocEntrada(docEntrada.getTipoDocEntrada().getNombre());
    dto.setIdMetodoPago(docEntrada.getMetodoPago().getIdmetododepago());
    dto.setMetodoPago(docEntrada.getMetodoPago().getNombre());
    dto.setIdMetodoPago(docEntrada.getMetodoPago().getIdmetododepago());
    dto.setEstadoPago(docEntrada.getEstadoPago().getNombre());
    dto.setIdEstadoPago(docEntrada.getEstadoPago().getIdestadoPago());
    dto.setEstadoIngreso(docEntrada.getEstadoIngreso().getNombre());
    dto.setIdEstadoIngreso(docEntrada.getEstadoIngreso().getIdestadoIngreso());
    dto.setEmpleado(docEntrada.getEmpleado().getPersona().getNombre() + " " + docEntrada.getEmpleado().getPersona().getApellido());
    dto.setIdEmpleado(docEntrada.getEmpleado().getIdempleado());
    dto.setProveedor(docEntrada.getProveedor().getPersona().getNombre() + " " + docEntrada.getProveedor().getPersona().getApellido());
    dto.setIdProveedor(docEntrada.getProveedor().getIdProveedor());
    dto.setNumeroDocumento(docEntrada.getNumeroDocumento());
    dto.setFechaIngreso(docEntrada.getFecha_ingreso());
    dto.setIncidencias(docEntrada.getIncidencias());
    dto.setPrecioTotal(docEntrada.getPrecioTotal());
    return dto;
    }

    // ================= HELPERS PRIVADOS =================
private static final Map<String, String> PREFIJOS_ENTRADA = Map.of(
    "NEA", "NEA",
    "Factura", "FAC",
    "Guia", "GUIA"
);

private String generarNumeroDocumento(TipoDocEntrada tipo) {
    String prefijo = PREFIJOS_ENTRADA.getOrDefault(tipo.getNombre(), "DOC");
    long correlativo = docEntradaRepository
            .countByTipoDocEntrada_Idtipodocentrada(tipo.getIdtipodocentrada()) + 1;
    return prefijo + "-" + String.format("%04d", correlativo);
}
}