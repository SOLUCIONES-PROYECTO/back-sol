package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.categoriaproducto.CategoriaProductoRequestDTO;
import edu.bodega.yessy.back_sol.dto.categoriaproducto.CategoriaProductoResponseDTO;
import edu.bodega.yessy.back_sol.models.CategoriaProducto;
import edu.bodega.yessy.back_sol.repositories.CategoriaProductoRepository;

@Service
public class CategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    public ArrayList<CategoriaProductoResponseDTO> listar() {
        ArrayList<CategoriaProductoResponseDTO> lista = new ArrayList<>();
        for (CategoriaProducto c : categoriaProductoRepository.findAll()) {
            lista.add(convertirDTO(c));
        }
        return lista;
    }

    public CategoriaProductoResponseDTO nuevo(CategoriaProductoRequestDTO dto) {
        CategoriaProducto c = new CategoriaProducto();
        c.setNombre(dto.getNombre());
        c.setDescripcion(dto.getDescripcion());
        return convertirDTO(categoriaProductoRepository.save(c));
    }

    public CategoriaProductoResponseDTO buscar(Integer id) {
        CategoriaProducto c = categoriaProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CategoriaProducto no encontrada"));
        return convertirDTO(c);
    }

    public CategoriaProductoResponseDTO actualizar(Integer id, CategoriaProductoRequestDTO dto) {
        CategoriaProducto c = categoriaProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CategoriaProducto no encontrada"));
        c.setNombre(dto.getNombre());
        c.setDescripcion(dto.getDescripcion());
        return convertirDTO(categoriaProductoRepository.save(c));
    }

    public void eliminar(Integer id) {
        CategoriaProducto c = categoriaProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CategoriaProducto no encontrada"));
        categoriaProductoRepository.delete(c);
    }

    private CategoriaProductoResponseDTO convertirDTO(CategoriaProducto c) {
        CategoriaProductoResponseDTO dto = new CategoriaProductoResponseDTO();
        dto.setIdCategoria(c.getIdCategoria());
        dto.setNombre(c.getNombre());
        dto.setDescripcion(c.getDescripcion());
        return dto;
    }
}
