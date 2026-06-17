package edu.bodega.yessy.back_sol.services;

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
        cliente.setEstado(dto.getEstado());
        cliente.setTipoCliente(dto.getTipoCliente());
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

    public void eliminar(Integer id){
        Cliente cliente = clienteRepository
            .findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Cliente no encontrado"));

        clienteRepository.delete(cliente);
    }

    public ClienteResponseDTO actualizar(
        Integer id,
        ClienteRequestDTO dto) {

    Cliente cliente = clienteRepository
            .findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Cliente no encontrado"));

    Persona persona = personaRepository
            .findById(dto.getIdPersona())
            .orElseThrow(() ->
                    new RuntimeException("Persona no encontrada"));

    cliente.setPersona(persona);

    cliente.setCodigoCliente(dto.getCodigoCliente());

    cliente.setFechaRegistro(dto.getFechaRegistro());

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

    
}