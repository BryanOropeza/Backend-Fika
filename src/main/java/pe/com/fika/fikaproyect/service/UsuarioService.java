package pe.com.fika.fikaproyect.service;

import pe.com.fika.fikaproyect.dto.UsuarioDTO;
import pe.com.fika.fikaproyect.model.LoginRequest;
import pe.com.fika.fikaproyect.model.ResetPasswordRequest;
import pe.com.fika.fikaproyect.service.generico.GenericoService;

public interface UsuarioService extends GenericoService<UsuarioDTO> {

    UsuarioDTO login(LoginRequest loginRequest);

    // Método para verificar si el nombre de usuario ya existe
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    UsuarioDTO resetPassword(ResetPasswordRequest resetRequest);

}
