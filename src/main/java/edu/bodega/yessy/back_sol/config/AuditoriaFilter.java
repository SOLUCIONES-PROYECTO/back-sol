package edu.bodega.yessy.back_sol.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuditoriaFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String usuarioSistema = request.getHeader("X-Usuario-Sistema");
        if (usuarioSistema != null && !usuarioSistema.isEmpty()) {
            AuditoriaContext.setCurrentUser(usuarioSistema);
        } else {
            AuditoriaContext.setCurrentUser("Sistema");
        }

        try {
            filterChain.doFilter(request, response);
        } finally {
            AuditoriaContext.clear();
        }
    }
}
