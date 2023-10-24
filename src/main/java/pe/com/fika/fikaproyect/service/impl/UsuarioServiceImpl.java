package pe.com.fika.fikaproyect.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import pe.com.fika.fikaproyect.dto.UsuarioDTO;
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
    public UsuarioDTO add(UsuarioDTO t) {
        UsuarioEntity user = mapper.map(t, UsuarioEntity.class);
        return mapper.map(repositorio.save(user), UsuarioDTO.class);
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
        user.setEstado("Eliminado");
        return mapper.map(repositorio.save(user), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO enable(Long id) {
        UsuarioEntity user = repositorio.findById(id).get();
        user.setEstado("Inhabilitado");
        return mapper.map(repositorio.save(user), UsuarioDTO.class);
    }
}
