package pe.com.fika.fikaproyect.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import pe.com.fika.fikaproyect.dto.UsuarioDTO;
import pe.com.fika.fikaproyect.model.LoginRequest;
import pe.com.fika.fikaproyect.model.UsuarioEntity;
import pe.com.fika.fikaproyect.repository.UsuarioRepository;
import pe.com.fika.fikaproyect.service.UsuarioService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UsuarioDTO> findAll() {
        List<UsuarioEntity> lista = repositorio.findAll();
        return lista.stream().map(c -> mapper.map(c, UsuarioDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDTO> findAllCustom() {
        List<UsuarioEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(c -> mapper.map(c, UsuarioDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findById(Long id) {
        UsuarioEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO add(UsuarioDTO usuarioDTO) {
        // Si las verificaciones pasan, procede a agregar el usuario
        UsuarioEntity userEntity = mapper.map(usuarioDTO, UsuarioEntity.class);
        return mapper.map(repositorio.save(userEntity), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO update(UsuarioDTO t, Long id) {
        UsuarioEntity user = repositorio.findById(id).get();
        mapper.map(t, user);
        return mapper.map(repositorio.save(user), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO delete(Long id) {
        UsuarioEntity user = repositorio.findById(id).get();
        user.setEstate("Eliminado");
        return mapper.map(repositorio.save(user), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO enable(Long id) {
        UsuarioEntity user = repositorio.findById(id).get();
        user.setEstate("Inhabilitado");
        return mapper.map(repositorio.save(user), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO login(LoginRequest loginRequest) {
        // Obtén el nombre de usuario y la contraseña desde el objeto LoginRequest.
        String username = loginRequest.getUser();
        String password = loginRequest.getPassword();

        // Realiza la lógica de validación de credenciales utilizando la consulta login
        // en el repositorio.
        UsuarioEntity usuario = repositorio.login(username, password);

        if (usuario != null) {
            // Utiliza ModelMapper u otra técnica para mapear la entidad a DTO.
            UsuarioDTO usuarioDTO = mapper.map(usuario, UsuarioDTO.class);
            return usuarioDTO;
        }

        return null; // Devuelve null si las credenciales son incorrectas o el usuario no existe.
    }

    @Override
    public boolean existsByUsername(String username) {
        return repositorio.existsByUser(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repositorio.existsByEmail(email);
    }

}
