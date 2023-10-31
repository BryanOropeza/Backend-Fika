package pe.com.fika.fikaproyect.service;

import pe.com.fika.fikaproyect.dto.UsuarioDTO;
import pe.com.fika.fikaproyect.model.LoginRequest;
import pe.com.fika.fikaproyect.service.generico.GenericoService;

public interface UsuarioService extends GenericoService<UsuarioDTO> {

    UsuarioDTO login(LoginRequest loginRequest);
}
