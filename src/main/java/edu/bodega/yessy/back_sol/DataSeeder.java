package edu.bodega.yessy.back_sol;

import edu.bodega.yessy.back_sol.models.Area;
import edu.bodega.yessy.back_sol.models.Cargo;
import edu.bodega.yessy.back_sol.models.Empleado;
import edu.bodega.yessy.back_sol.models.Persona;
import edu.bodega.yessy.back_sol.repositories.AreaRepository;
import edu.bodega.yessy.back_sol.repositories.CargoRepository;
import edu.bodega.yessy.back_sol.repositories.EmpleadoRepository;
import edu.bodega.yessy.back_sol.repositories.PersonaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final CargoRepository cargoRepository;
    private final EmpleadoRepository empleadoRepository;
    private final PersonaRepository personaRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(AreaRepository areaRepository,
                      CargoRepository cargoRepository,
                      EmpleadoRepository empleadoRepository,
                      PersonaRepository personaRepository,
                      PasswordEncoder passwordEncoder) {
        this.areaRepository = areaRepository;
        this.cargoRepository = cargoRepository;
        this.empleadoRepository = empleadoRepository;
        this.personaRepository = personaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Sembrar Áreas
        if (areaRepository.count() == 0) {
            Area area1 = new Area();
            area1.setNombre("Administración");
            areaRepository.save(area1);

            Area area2 = new Area();
            area2.setNombre("Ventas");
            areaRepository.save(area2);
        }

        // Sembrar Cargos
        if (cargoRepository.count() == 0) {
            Cargo cargo1 = new Cargo();
            cargo1.setNombre("Administrador");
            cargoRepository.save(cargo1);

            Cargo cargo2 = new Cargo();
            cargo2.setNombre("Vendedor");
            cargoRepository.save(cargo2);
        }

        // Sembrar un Empleado Admin por defecto para pruebas
        if (empleadoRepository.count() == 0) {
            Persona adminPersona = new Persona();
            adminPersona.setNombre("Admin");
            adminPersona.setApellido("Sistema");
            adminPersona.setDni("00000000");
            adminPersona.setCorreo("antoninoseminario@gmail.com"); // Pongo este correo para que pueda probar recuperar contraseña
            adminPersona.setFechaRegistro(LocalDateTime.now());
            personaRepository.save(adminPersona);

            Empleado admin = new Empleado();
            admin.setPersona(adminPersona);
            admin.setUsuarioSistema("admin");
            admin.setContrasena(passwordEncoder.encode("12345678")); // Clave por defecto
            admin.setCargo("Administrador");
            admin.setArea("Administración");
            admin.setEstado("ACTIVO");
            admin.setRol("Administrador");
            admin.setFechaContratacion(LocalDate.now());
            admin.setFechaRegistro(LocalDateTime.now());
            admin.setTurnoTrabajo("Mañana");
            admin.setSupervisorDirecto("N/A");
            empleadoRepository.save(admin);
        }
    }
}
