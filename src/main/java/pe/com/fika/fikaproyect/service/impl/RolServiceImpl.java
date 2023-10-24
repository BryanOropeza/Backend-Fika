package pe.com.fika.fikaproyect.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import pe.com.fika.fikaproyect.dto.RolDTO;
import pe.com.fika.fikaproyect.model.RolEntity;
import pe.com.fika.fikaproyect.repository.RolRepository;
import pe.com.fika.fikaproyect.service.RolService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<RolDTO> findAll() {
        List<RolEntity> lista = repositorio.findAll();
        return lista.stream().map(c -> mapper.map(c, RolDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<RolDTO> findAllCustom() {
        List<RolEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(c -> mapper.map(c, RolDTO.class)).collect(Collectors.toList());
    }

    @Override
    public RolDTO findById(Long id) {
        RolEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, RolDTO.class);
    }

    @Override
    public RolDTO add(RolDTO t) {
        RolEntity rol = mapper.map(t, RolEntity.class);
        return mapper.map(repositorio.save(rol), RolDTO.class);
    }

    @Override
    public RolDTO update(RolDTO t, Long id) {
        RolEntity rol = repositorio.findById(id).get();
        mapper.map(t, rol);
        return mapper.map(repositorio.save(rol), RolDTO.class);
    }

    @Override
    public RolDTO delete(Long id) {
        RolEntity rol = repositorio.findById(id).get();
        rol.setEstado("Eliminado");
        return mapper.map(repositorio.save(rol), RolDTO.class);
    }

    @Override
    public RolDTO enable(Long id) {
        RolEntity rol = repositorio.findById(id).get();
        rol.setEstado("Inhabilitado");
        return mapper.map(repositorio.save(rol), RolDTO.class);
    }
}
