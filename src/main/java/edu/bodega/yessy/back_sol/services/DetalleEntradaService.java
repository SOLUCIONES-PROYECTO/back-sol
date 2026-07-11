package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.detalleentrada.DetalleEntradaRequestDTO;
import edu.bodega.yessy.back_sol.dto.detalleentrada.DetalleEntradaResponseDTO;
import edu.bodega.yessy.back_sol.models.DetalleEntrada;
import edu.bodega.yessy.back_sol.models.DocEntrada;
import edu.bodega.yessy.back_sol.models.Producto;
import edu.bodega.yessy.back_sol.repositories.DetalleEntradaRepository;
import edu.bodega.yessy.back_sol.repositories.DocEntradaRepository;
import edu.bodega.yessy.back_sol.repositories.ProductoRepository;

@Service
public class DetalleEntradaService {

    @Autowired
    private DetalleEntradaRepository detalleEntradaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DocEntradaRepository docEntradaRepository;

    public ArrayList<DetalleEntradaResponseDTO> listar() {

        ArrayList<DetalleEntradaResponseDTO> lista = new ArrayList<>();

        for (DetalleEntrada entity : detalleEntradaRepository.findAll()) {
            lista.add(convertirDTO(entity));
        }

        return lista;
    }


    public DetalleEntradaResponseDTO nuevo(DetalleEntradaRequestDTO dto) {

        Producto producto = productoRepository
                .findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        DocEntrada docEntrada = docEntradaRepository
                .findById(dto.getIdDocEntrada())
                .orElseThrow(() -> new RuntimeException("Documento de entrada no encontrado"));

        DetalleEntrada entity = new DetalleEntrada();

        entity.setProducto(producto);
        entity.setDocEntrada(docEntrada);

        entity.setCantidad(dto.getCantidad());
        entity.setSubtotal(dto.getSubtotal());
        entity.setLoteproducto(dto.getLoteProducto());
        entity.setFechavencimiento(dto.getFechaVencimiento());
        entity.setPreciounitario(dto.getPrecioUnitario());

        // 🔥 AUMENTAR STOCK
        producto.setStockActual(producto.getStockActual() + dto.getCantidad());
        productoRepository.save(producto);

        DetalleEntrada guardado = detalleEntradaRepository.save(entity);

        return convertirDTO(guardado);
    }

    public DetalleEntradaResponseDTO buscar(Integer id) {

        DetalleEntrada entity = detalleEntradaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de entrada no encontrado"));

        return convertirDTO(entity);
    }

    public DetalleEntradaResponseDTO actualizar(Integer id, DetalleEntradaRequestDTO dto) {

        DetalleEntrada entity = detalleEntradaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de entrada no encontrado"));

        Producto producto = productoRepository
                .findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        DocEntrada docEntrada = docEntradaRepository
                .findById(dto.getIdDocEntrada())
                .orElseThrow(() -> new RuntimeException("Documento de entrada no encontrado"));

        entity.setProducto(producto);
        entity.setDocEntrada(docEntrada);

        entity.setCantidad(dto.getCantidad());
        entity.setSubtotal(dto.getSubtotal());
        entity.setLoteproducto(dto.getLoteProducto());
        entity.setFechavencimiento(dto.getFechaVencimiento());
        entity.setPreciounitario(dto.getPrecioUnitario());

        DetalleEntrada actualizado = detalleEntradaRepository.save(entity);

        return convertirDTO(actualizado);
    }


    public void eliminar(Integer id) {

        DetalleEntrada entity = detalleEntradaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de entrada no encontrado"));

        detalleEntradaRepository.delete(entity);
    }


    private DetalleEntradaResponseDTO convertirDTO(DetalleEntrada entity) {

        DetalleEntradaResponseDTO dto = new DetalleEntradaResponseDTO();

        dto.setIdDetalleEntrada(entity.getIddetalleEntrada());

        dto.setCantidad(entity.getCantidad());
        dto.setSubtotal(entity.getSubtotal());
        dto.setLoteProducto(entity.getLoteproducto());
        dto.setFechaVencimiento(entity.getFechavencimiento());
        dto.setPrecioUnitario(entity.getPreciounitario());

        // PRODUCTO
        dto.setIdProducto(entity.getProducto().getIdproducto());
        dto.setNombreProducto(entity.getProducto().getNombre());

        // DOC ENTRADA
        dto.setIdDocEntrada(entity.getDocEntrada().getIddocentrada());
        dto.setNumeroDocumento(entity.getDocEntrada().getNumeroDocumento());

        return dto;
    }
}