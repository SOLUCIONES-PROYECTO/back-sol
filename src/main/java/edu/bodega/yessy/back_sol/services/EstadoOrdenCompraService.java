package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.estadoordencompra.EstadoOrdenCompraRequest;
import edu.bodega.yessy.back_sol.dto.estadoordencompra.EstadoOrdenCompraResponse;
import edu.bodega.yessy.back_sol.models.EstadoOrdenCompra;
import edu.bodega.yessy.back_sol.repositories.EstadoOrdenCompraRepository;

@Service
public class EstadoOrdenCompraService {

    @Autowired
    private EstadoOrdenCompraRepository estadoOrdenCompraRepository;

    // ================= LISTAR =================
    public ArrayList<EstadoOrdenCompraResponse> listar() {

        ArrayList<EstadoOrdenCompraResponse> lista = new ArrayList<>();

        for (EstadoOrdenCompra estado : estadoOrdenCompraRepository.findAll()) {
            lista.add(convertirDTO(estado));
        }

        return lista;
    }

    // ================= CREAR =================
    public EstadoOrdenCompraResponse nuevo(EstadoOrdenCompraRequest dto) {

        EstadoOrdenCompra estado = new EstadoOrdenCompra();

        estado.setNombre(dto.getNombre());

        return convertirDTO(estadoOrdenCompraRepository.save(estado));
    }

    // ================= BUSCAR =================
    public EstadoOrdenCompraResponse buscar(Integer id) {

        EstadoOrdenCompra estado = estadoOrdenCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado de orden de compra no encontrado"));

        return convertirDTO(estado);
    }

    // ================= BUSCAR POR NOMBRE =================
    public EstadoOrdenCompra buscarPorNombre(String nombre) {

        return estadoOrdenCompraRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException(
                        "Estado de orden de compra '" + nombre + "' no encontrado"));
    }

    // ================= BUSCAR ENTIDAD =================
    public EstadoOrdenCompra buscarEntidad(Integer id) {

        return estadoOrdenCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Estado de orden de compra no encontrado"));
    }

    // ================= ACTUALIZAR =================
    public EstadoOrdenCompraResponse actualizar(Integer id, EstadoOrdenCompraRequest dto) {

        EstadoOrdenCompra estado = estadoOrdenCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado de orden de compra no encontrado"));

        estado.setNombre(dto.getNombre());

        return convertirDTO(estadoOrdenCompraRepository.save(estado));
    }

    // ================= ELIMINAR =================
    public void eliminar(Integer id) {

        EstadoOrdenCompra estado = estadoOrdenCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado de orden de compra no encontrado"));

        estadoOrdenCompraRepository.delete(estado);
    }

    // ================= MAPPER =================
    private EstadoOrdenCompraResponse convertirDTO(EstadoOrdenCompra estado) {

        EstadoOrdenCompraResponse dto = new EstadoOrdenCompraResponse();

        dto.setIdestadoOc(estado.getIdestadoOc());
        dto.setNombre(estado.getNombre());

        return dto;
    }

}