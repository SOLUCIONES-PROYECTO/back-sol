package edu.bodega.yessy.back_sol.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.cliente.ClienteRequestDTO;
import edu.bodega.yessy.back_sol.dto.cliente.ClienteResponseDTO;
import edu.bodega.yessy.back_sol.models.Cliente;
import edu.bodega.yessy.back_sol.models.Persona;
import edu.bodega.yessy.back_sol.repositories.ClienteRepository;
import edu.bodega.yessy.back_sol.repositories.PersonaRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public ClienteResponseDTO nuevo(ClienteRequestDTO dto) {

        Persona persona = personaRepository
                .findById(dto.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Cliente cliente = new Cliente();

        cliente.setPersona(persona);
        cliente.setCodigoCliente(dto.getCodigoCliente());
        cliente.setFechaRegistro(LocalDateTime.now());

        cliente.setEstado(dto.getEstado());
        cliente.setTipoCliente(dto.getTipoCliente());
        cliente.setLimiteCredito(dto.getLimiteCredito());
        cliente.setObservaciones(dto.getObservaciones());
        cliente.setCategoriaCliente(dto.getCategoriaCliente());
        cliente.setFechaUltimaCompra(dto.getFechaUltimaCompra());
        cliente.setFrecuenciaCompra(dto.getFrecuenciaCompra());

        Cliente guardado = clienteRepository.save(cliente);

        return convertirDTO(guardado);
    }

    private ClienteResponseDTO convertirDTO(Cliente cliente) {

        ClienteResponseDTO dto = new ClienteResponseDTO();

        dto.setIdcliente(cliente.getIdcliente());

        dto.setNombre(
                cliente.getPersona().getNombre());

        dto.setApellido(
                cliente.getPersona().getApellido());

        dto.setCodigoCliente(cliente.getCodigoCliente());
        dto.setIdPersona(cliente.getPersona().getIdpersona());
        dto.setObservaciones(cliente.getObservaciones());

        dto.setEstado(cliente.getEstado());

        dto.setTipoCliente(cliente.getTipoCliente());

        dto.setLimiteCredito(cliente.getLimiteCredito());

        dto.setCategoriaCliente(cliente.getCategoriaCliente());

        dto.setFechaUltimaCompra(cliente.getFechaUltimaCompra());

        dto.setFrecuenciaCompra(cliente.getFrecuenciaCompra());

        return dto;
    }

    public ArrayList<ClienteResponseDTO> listar() {

        ArrayList<ClienteResponseDTO> lista = new ArrayList<>();

        for (Cliente cliente : clienteRepository.findAll()) {
            lista.add(convertirDTO(cliente));
        }

        return lista;
    }

    public ClienteResponseDTO buscar(Integer id) {

        Cliente cliente = clienteRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return convertirDTO(cliente);
    }

    public void eliminar(Integer id) {
        Cliente cliente = clienteRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        clienteRepository.delete(cliente);
    }

    public ClienteResponseDTO actualizar(
            Integer id,
            ClienteRequestDTO dto) {

        Cliente cliente = clienteRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Persona persona = personaRepository
                .findById(dto.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        cliente.setPersona(persona);
        cliente.setCodigoCliente(dto.getCodigoCliente());
        cliente.setEstado(dto.getEstado());
        cliente.setTipoCliente(dto.getTipoCliente());
        cliente.setLimiteCredito(dto.getLimiteCredito());
        cliente.setObservaciones(dto.getObservaciones());
        cliente.setCategoriaCliente(dto.getCategoriaCliente());
        cliente.setFechaUltimaCompra(dto.getFechaUltimaCompra());
        cliente.setFrecuenciaCompra(dto.getFrecuenciaCompra());

        Cliente actualizado = clienteRepository.save(cliente);

        return convertirDTO(actualizado);
    }

    public Cliente buscarOCrearPorDni(String nombre, String apellido, String dni) {

        Persona persona = personaRepository.findByDni(dni)
                .orElseGet(() -> {
                    Persona nueva = new Persona();
                    nueva.setNombre(nombre);
                    nueva.setApellido(apellido);
                    nueva.setDni(dni);
                    nueva.setFechaRegistro(LocalDateTime.now());
                    return personaRepository.save(nueva);
                });

        return clienteRepository.findByPersona_Idpersona(persona.getIdpersona())
                .orElseGet(() -> crearClientePorDefecto(persona, "CLI-" + persona.getIdpersona(), "Ocasional"));
    }

    public Cliente obtenerClienteCentinela() {

        final String dniCentinela = "00000000";

        Persona persona = personaRepository.findByDni(dniCentinela)
                .orElseGet(() -> {
                    Persona nueva = new Persona();
                    nueva.setNombre("Consumo");
                    nueva.setApellido("Interno");
                    nueva.setDni(dniCentinela);
                    nueva.setFechaRegistro(LocalDateTime.now());
                    return personaRepository.save(nueva);
                });

        return clienteRepository.findByPersona_Idpersona(persona.getIdpersona())
                .orElseGet(() -> crearClientePorDefecto(persona, "CLI-INTERNO", "Interno"));
    }

    public Cliente obtenerClienteProductoVencido() {

    final String dniProductoVencido = "00000001"; // distinto al centinela (00000000)

    Persona persona = personaRepository.findByDni(dniProductoVencido)
            .orElseGet(() -> {
                Persona nueva = new Persona();
                nueva.setNombre("Producto");
                nueva.setApellido("Vencido");
                nueva.setDni(dniProductoVencido);
                nueva.setFechaRegistro(LocalDateTime.now());
                return personaRepository.save(nueva);
            });

    return clienteRepository.findByPersona_Idpersona(persona.getIdpersona())
            .orElseGet(() -> crearClientePorDefecto(persona, "CLI-MERMA", "Merma"));
}


    private Cliente crearClientePorDefecto(Persona persona, String codigoCliente, String tipoCliente) {

        Cliente cliente = new Cliente();
        cliente.setPersona(persona);
        cliente.setCodigoCliente(codigoCliente);
        cliente.setFechaRegistro(LocalDateTime.now());
        cliente.setEstado("Activo");
        cliente.setTipoCliente(tipoCliente);
        cliente.setLimiteCredito(BigDecimal.ZERO);
        cliente.setCategoriaCliente("Regular");
        cliente.setFechaUltimaCompra(LocalDate.now());
        cliente.setFrecuenciaCompra("N/A");

        return clienteRepository.save(cliente);
    }

}
