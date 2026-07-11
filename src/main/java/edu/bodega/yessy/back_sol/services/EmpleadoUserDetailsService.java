package edu.bodega.yessy.back_sol.services;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.bodega.yessy.back_sol.models.Empleado;
import edu.bodega.yessy.back_sol.repositories.EmpleadoRepository;

@Service
public class EmpleadoUserDetailsService implements UserDetailsService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoUserDetailsService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuarioSistema) throws UsernameNotFoundException {

        Empleado empleado = empleadoRepository.findByUsuarioSistema(usuarioSistema)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        boolean activo = "ACTIVO".equalsIgnoreCase(empleado.getEstado());

        return User.builder()
                .username(empleado.getUsuarioSistema())
                .password(empleado.getContrasena() != null ? empleado.getContrasena() : "")
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_" + empleado.getRol().toUpperCase())))
                .disabled(!activo)
                .build();
    }
}
