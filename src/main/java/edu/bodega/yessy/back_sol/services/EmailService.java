package edu.bodega.yessy.back_sol.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarCorreoRecuperacion(String destino, String token) {
        String enlaceRecuperacion = "http://localhost:4200/auth/reset-password?token=" + token;
        
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom("arcom4302@gmail.com");
        mensaje.setTo(destino);
        mensaje.setSubject("Recuperación de Contraseña - Sistema Bodega");
        mensaje.setText("Hola,\n\n"
                + "Has solicitado restablecer tu contraseña. Haz clic en el siguiente enlace para crear una nueva contraseña:\n\n"
                + enlaceRecuperacion + "\n\n"
                + "Este enlace expirará en 15 minutos.\n\n"
                + "Si no solicitaste esto, puedes ignorar este correo.");

        mailSender.send(mensaje);
    }
}
