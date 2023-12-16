package pe.com.fika.fikaproyect.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import pe.com.fika.fikaproyect.dto.PacienteDTO;
import pe.com.fika.fikaproyect.model.PacienteEntity;
import pe.com.fika.fikaproyect.model.UsuarioEntity;
import pe.com.fika.fikaproyect.repository.PacienteRepository;
import pe.com.fika.fikaproyect.repository.UsuarioRepository;
import pe.com.fika.fikaproyect.service.PacienteService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository repositorio;

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public PacienteDTO crearPaciente(Long usuarioId, PacienteDTO pacienteDTO) {
        UsuarioEntity usuario = usuarioRepositorio.findById(usuarioId)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));

        PacienteEntity paciente = mapper.map(pacienteDTO, PacienteEntity.class);
        paciente.setUsuario(usuario);

        PacienteEntity pacienteGuardado = repositorio.save(paciente);
        return mapper.map(pacienteGuardado, PacienteDTO.class);
    }

    @Override
    public List<PacienteDTO> findAll() {
        List<PacienteEntity> lista = repositorio.findAll();
        return lista.stream().map(c -> mapper.map(c, PacienteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PacienteDTO> findAllCustom() {
        List<PacienteEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(c -> mapper.map(c, PacienteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PacienteDTO findById(Long id) {
        PacienteEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, PacienteDTO.class);
    }

    @Override
    public PacienteDTO add(PacienteDTO t) {
        PacienteEntity paciente = mapper.map(t, PacienteEntity.class);
        return mapper.map(repositorio.save(paciente), PacienteDTO.class);
    }

    @Override
    public PacienteDTO update(PacienteDTO t, Long id) {
        PacienteEntity paciente = repositorio.findById(id).get();
        mapper.map(t, paciente);
        return mapper.map(repositorio.save(paciente), PacienteDTO.class);
    }

    @Override
    public PacienteDTO delete(Long id) {
        PacienteEntity paciente = repositorio.findById(id).get();
        paciente.setEstado("Eliminado");
        return mapper.map(repositorio.save(paciente), PacienteDTO.class);
    }

    @Override
    public PacienteDTO enable(Long id) {
        PacienteEntity paciente = repositorio.findById(id).get();
        paciente.setEstado("Inhabilitado");
        return mapper.map(repositorio.save(paciente), PacienteDTO.class);
    }
}
