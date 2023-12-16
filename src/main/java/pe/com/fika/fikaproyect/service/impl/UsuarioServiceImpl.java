package pe.com.fika.fikaproyect.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import pe.com.fika.fikaproyect.dto.UsuarioDTO;
import pe.com.fika.fikaproyect.model.LoginRequest;
import pe.com.fika.fikaproyect.model.ResetPasswordRequest;
import pe.com.fika.fikaproyect.model.UsuarioEntity;
import pe.com.fika.fikaproyect.repository.UsuarioRepository;
import pe.com.fika.fikaproyect.service.UsuarioService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repositorio;

    private final BCryptPasswordEncoder passwordEncoder;

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
        // Encriptar la contraseña antes de guardarla
        String contraseñaEncriptada = passwordEncoder.encode(usuarioDTO.getPassword());
        usuarioDTO.setPassword(contraseñaEncriptada);

        UsuarioEntity userEntity = mapper.map(usuarioDTO, UsuarioEntity.class);
        return mapper.map(repositorio.save(userEntity), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO resetPassword(ResetPasswordRequest resetRequest) {
        String username = resetRequest.getUser();
        String newPassword = resetRequest.getPassword();

        // Encuentra al usuario por su nombre de usuario
        UsuarioEntity usuario = repositorio.findByUsername(username);

        if (usuario != null) {
            // Actualiza la contraseña del usuario
            String contraseñaEncriptada = passwordEncoder.encode(newPassword);
            usuario.setPassword(contraseñaEncriptada);
            return mapper.map(repositorio.save(usuario), UsuarioDTO.class);
        } else {
            // Maneja el caso en el que el usuario no existe
            throw new RuntimeException("Usuario no encontrado");
        }
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
        String username = loginRequest.getUser();
        String password = loginRequest.getPassword();

        UsuarioEntity usuario = repositorio.findByUsername(username);

        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario.getUser());

            if (passwordEncoder.matches(password, usuario.getPassword())) {
                System.out.println("Contraseña coincidente para el usuario: " + usuario.getUser());
                UsuarioDTO usuarioDTO = mapper.map(usuario, UsuarioDTO.class);
                return usuarioDTO;
            } else {
                System.out.println("Contraseña incorrecta para el usuario: " + usuario.getUser());
            }
        } else {
            System.out.println("Usuario no encontrado");
        }

        return null; // Asegúrate de devolver null si no se autentica correctamente.
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
