package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.producto.ProductoRequestDTO;
import edu.bodega.yessy.back_sol.dto.producto.ProductoResponseDTO;
import edu.bodega.yessy.back_sol.models.EstadoProducto;
import edu.bodega.yessy.back_sol.models.Producto;
import edu.bodega.yessy.back_sol.models.Proveedor;
import edu.bodega.yessy.back_sol.models.UnidadMedida;
import edu.bodega.yessy.back_sol.repositories.EstadoProductoRepository;
import edu.bodega.yessy.back_sol.repositories.ProductoRepository;
import edu.bodega.yessy.back_sol.repositories.ProveedorRepository;
import edu.bodega.yessy.back_sol.repositories.UnidadMedidaRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private EstadoProductoRepository estadoProductoRepository;

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public ArrayList<ProductoResponseDTO> listar() {

        ArrayList<ProductoResponseDTO> lista = new ArrayList<>();

        for (Producto producto : productoRepository.findAll()) {
            lista.add(convertirDTO(producto));
        }

        return lista;
    }

    public ProductoResponseDTO nuevo(ProductoRequestDTO dto) {

        Proveedor proveedor = proveedorRepository
                .findById(dto.getIdProveedor())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        EstadoProducto estado = estadoProductoRepository
                .findById(dto.getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        UnidadMedida unidadMedida = unidadMedidaRepository
                .findById(dto.getIdUnidadMedida())
                .orElseThrow(() -> new RuntimeException("Unidad de medida no encontrada"));

        Producto producto = new Producto();

        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setCategoria(dto.getCategoria());

        producto.setProveedor(proveedor);

        producto.setPrecioCompra(dto.getPrecioCompra());
        producto.setPrecioVenta(dto.getPrecioVenta());

        producto.setStockMinimo(dto.getStockMinimo());
        producto.setStockActual(dto.getStockActual());

        producto.setImagen(dto.getImagen());

        producto.setMargen(dto.getMargen());
        producto.setGanancia(dto.getGanancia());

        producto.setEstado(estado);

        producto.setUnidadMedida(unidadMedida);

        Producto guardado = productoRepository.save(producto);

        return convertirDTO(guardado);
    }

    public ProductoResponseDTO buscar(Integer id) {
        Producto producto = productoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return convertirDTO(producto);
    }

    public ProductoResponseDTO actualizar(
        Integer id,
        ProductoRequestDTO dto) {

    Producto producto = productoRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

    Proveedor proveedor = proveedorRepository
            .findById(dto.getIdProveedor())
            .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

    EstadoProducto estado = estadoProductoRepository
            .findById(dto.getIdEstado())
            .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

    UnidadMedida unidadMedida = unidadMedidaRepository
            .findById(dto.getIdUnidadMedida())
            .orElseThrow(() -> new RuntimeException("Unidad de medida no encontrada"));

    producto.setNombre(dto.getNombre());
    producto.setDescripcion(dto.getDescripcion());
    producto.setCategoria(dto.getCategoria());

    producto.setProveedor(proveedor);

    producto.setPrecioCompra(dto.getPrecioCompra());
    producto.setPrecioVenta(dto.getPrecioVenta());

    producto.setStockMinimo(dto.getStockMinimo());
    producto.setStockActual(dto.getStockActual());

    producto.setImagen(dto.getImagen());

    producto.setMargen(dto.getMargen());
    producto.setGanancia(dto.getGanancia());

    producto.setEstado(estado);

    producto.setUnidadMedida(unidadMedida);

    Producto actualizado = productoRepository.save(producto);

    return convertirDTO(actualizado);
}

public void eliminar(Integer id) {

    Producto producto = productoRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

    productoRepository.delete(producto);
}

    private ProductoResponseDTO convertirDTO(Producto producto) {

        ProductoResponseDTO dto = new ProductoResponseDTO();

        dto.setIdproducto(producto.getIdproducto());

        dto.setNombre(producto.getNombre());

        dto.setDescripcion(producto.getDescripcion());

        dto.setCategoria(producto.getCategoria());

        dto.setProveedor(producto.getProveedor().getDescripcion());

        dto.setPrecioCompra(producto.getPrecioCompra());

        dto.setPrecioVenta(producto.getPrecioVenta());

        dto.setStockActual(producto.getStockActual());

        dto.setEstado(producto.getEstado().getNombre());

        dto.setUnidadMedida(producto.getUnidadMedida().getNombre());

        dto.setStockMinimo(producto.getStockMinimo());
dto.setImagen(producto.getImagen());
dto.setMargen(producto.getMargen());
dto.setGanancia(producto.getGanancia());
        return dto;
    }
}