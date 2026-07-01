package edu.bodega.yessy.back_sol.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.dto.cargo.CargoRequestDTO;
import edu.bodega.yessy.back_sol.dto.cargo.CargoResponseDTO;
import edu.bodega.yessy.back_sol.models.Cargo;
import edu.bodega.yessy.back_sol.repositories.CargoRepository;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public ArrayList<CargoResponseDTO> listar() {
        ArrayList<CargoResponseDTO> lista = new ArrayList<>();
        for (Cargo c : cargoRepository.findAll()) {
            lista.add(convertirDTO(c));
        }
        return lista;
    }

    public CargoResponseDTO nuevo(CargoRequestDTO dto) {
        Cargo c = new Cargo();
        c.setNombre(dto.getNombre());
        return convertirDTO(cargoRepository.save(c));
    }

    public CargoResponseDTO buscar(Integer id) {
        Cargo c = cargoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado"));
        return convertirDTO(c);
    }

    public CargoResponseDTO actualizar(Integer id, CargoRequestDTO dto) {
        Cargo c = cargoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado"));
        c.setNombre(dto.getNombre());
        return convertirDTO(cargoRepository.save(c));
    }

    public void eliminar(Integer id) {
        Cargo c = cargoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado"));
        cargoRepository.delete(c);
    }

    private CargoResponseDTO convertirDTO(Cargo c) {
        CargoResponseDTO dto = new CargoResponseDTO();
        dto.setIdCargo(c.getIdCargo());
        dto.setNombre(c.getNombre());
        return dto;
    }
}
