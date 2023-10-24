package pe.com.fika.fikaproyect.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import pe.com.fika.fikaproyect.dto.PacienteDTO;
import pe.com.fika.fikaproyect.model.PacienteEntity;
import pe.com.fika.fikaproyect.repository.PacienteRepository;
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
    private ModelMapper mapper;

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
