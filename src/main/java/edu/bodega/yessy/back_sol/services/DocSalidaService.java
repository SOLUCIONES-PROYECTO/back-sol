package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.docsalida.DocSalidaRequest;
import edu.bodega.yessy.back_sol.dto.docsalida.DocSalidaResponseDTO;
import edu.bodega.yessy.back_sol.models.Cliente;
import edu.bodega.yessy.back_sol.models.DocSalida;
import edu.bodega.yessy.back_sol.models.Empleado;
import edu.bodega.yessy.back_sol.models.MetodoPago;
import edu.bodega.yessy.back_sol.models.TipoDocSalida;
import edu.bodega.yessy.back_sol.repositories.ClienteRepository;
import edu.bodega.yessy.back_sol.repositories.DocSalidaRepository;
import edu.bodega.yessy.back_sol.repositories.EmpleadoRepository;
import edu.bodega.yessy.back_sol.repositories.MetodoPagoRepository;
import edu.bodega.yessy.back_sol.repositories.TipoDocSalidaRepository;

@Service
public class DocSalidaService {

        @Autowired
        private DocSalidaRepository docSalidaRepository;

        @Autowired
        private TipoDocSalidaRepository tipoDocSalidaRepository;

        @Autowired
        private ClienteRepository clienteRepository;

        @Autowired
        private EmpleadoRepository empleadoRepository;

        @Autowired
        private MetodoPagoRepository metodoPagoRepository;

        @Autowired
        private ClienteService clienteService;

        public ArrayList<DocSalidaResponseDTO> listar() {
                ArrayList<DocSalidaResponseDTO> lista = new ArrayList<>();

                for (DocSalida docSalida : docSalidaRepository.findAll()) {
                        lista.add(convertirDTO(docSalida));
                }

                return lista;
        }

        public DocSalidaResponseDTO nuevo(DocSalidaRequest dto) {
                TipoDocSalida tipoDocSalida = tipoDocSalidaRepository
                                .findById(dto.getIdTipoDocSalida())
                                .orElseThrow(() -> new RuntimeException("Tipo de documento de salida no encontrado"));

                java.util.Set<String> tiposConCliente = java.util.Set.of("Boleta", "Factura", "Ticket");

                Cliente cliente = tiposConCliente.contains(tipoDocSalida.getNombre())
                                ? clienteService.buscarOCrearPorDni(dto.getNombreCliente(), dto.getApellidoCliente(),
                                                dto.getDniCliente())
                                : clienteService.obtenerClienteCentinela();

                Empleado empleado = empleadoRepository
                                .findById(dto.getIdEmpleado())
                                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

                MetodoPago metodoPago = metodoPagoRepository
                                .findById(dto.getIdMetodoPago())
                                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

                DocSalida docSalida = new DocSalida();

                docSalida.setTipoDocSalida(tipoDocSalida);
                docSalida.setCliente(cliente);
                docSalida.setEmpleado(empleado);
                docSalida.setNumeroDocumento(dto.getNumeroDocumento());
                docSalida.setFechaRegistro(dto.getFechaRegistro());
                docSalida.setFechaEgreso(dto.getFechaEgreso());
                docSalida.setDescripcion(dto.getDescripcion());
                docSalida.setTotalSalida(dto.getTotalSalida());
                docSalida.setMetodoPago(metodoPago);

                DocSalida guardado = docSalidaRepository.save(docSalida);

                return convertirDTO(guardado);
        }

        public DocSalidaResponseDTO buscar(Integer id) {
                DocSalida docSalida = docSalidaRepository
                                .findById(id)
                                .orElseThrow(() -> new RuntimeException("DocSalida no encontrado"));

                return convertirDTO(docSalida);
        }

        public DocSalidaResponseDTO actualizar(Integer id, DocSalidaRequest dto) {
                DocSalida docSalida = docSalidaRepository
                                .findById(id)
                                .orElseThrow(() -> new RuntimeException("DocSalida no encontrado"));

                TipoDocSalida tipoDocSalida = tipoDocSalidaRepository
                                .findById(dto.getIdTipoDocSalida())
                                .orElseThrow(() -> new RuntimeException("Tipo de documento de salida no encontrado"));

                java.util.Set<String> tiposConCliente = java.util.Set.of("Boleta", "Factura", "Ticket");

                Cliente cliente = tiposConCliente.contains(tipoDocSalida.getNombre())
                                ? clienteService.buscarOCrearPorDni(dto.getNombreCliente(), dto.getApellidoCliente(),
                                                dto.getDniCliente())
                                : clienteService.obtenerClienteCentinela();

                Empleado empleado = empleadoRepository
                                .findById(dto.getIdEmpleado())
                                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

                MetodoPago metodoPago = metodoPagoRepository
                                .findById(dto.getIdMetodoPago())
                                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

                docSalida.setTipoDocSalida(tipoDocSalida);
                docSalida.setCliente(cliente);
                docSalida.setEmpleado(empleado);
                docSalida.setNumeroDocumento(dto.getNumeroDocumento());
                docSalida.setFechaRegistro(dto.getFechaRegistro());
                docSalida.setFechaEgreso(dto.getFechaEgreso());
                docSalida.setDescripcion(dto.getDescripcion());
                docSalida.setTotalSalida(dto.getTotalSalida());
                docSalida.setMetodoPago(metodoPago);

                DocSalida actualizado = docSalidaRepository.save(docSalida);

                return convertirDTO(actualizado);
        }

        public void eliminar(Integer id) {
                DocSalida docSalida = docSalidaRepository
                                .findById(id)
                                .orElseThrow(() -> new RuntimeException("DocSalida no encontrado"));

                docSalidaRepository.delete(docSalida);
        }

        private DocSalidaResponseDTO convertirDTO(DocSalida docSalida) {
                DocSalidaResponseDTO dto = new DocSalidaResponseDTO();

                dto.setIddocsalida(docSalida.getIddocsalida());
                dto.setTipoDocSalida(docSalida.getTipoDocSalida().getNombre());
                dto.setCliente(docSalida.getCliente().getPersona().getNombre() + " "
                                + docSalida.getCliente().getPersona().getApellido());
                dto.setEmpleado(docSalida.getEmpleado().getPersona().getNombre() + " "
                                + docSalida.getEmpleado().getPersona().getApellido());
                dto.setNumeroDocumento(docSalida.getNumeroDocumento());
                dto.setFechaRegistro(docSalida.getFechaRegistro());
                dto.setFechaEgreso(docSalida.getFechaEgreso());
                dto.setDescripcion(docSalida.getDescripcion());
                dto.setTotalSalida(docSalida.getTotalSalida());
                dto.setMetodoPago(docSalida.getMetodoPago().getNombre());

                return dto;
        }
}
