package pe.com.fika.fikaproyect.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import pe.com.fika.fikaproyect.dto.CitaDTO;
import pe.com.fika.fikaproyect.model.CitaEntity;
import pe.com.fika.fikaproyect.repository.CitaRepository;
import pe.com.fika.fikaproyect.service.CitaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CitaDTO> findAll() {
        List<CitaEntity> lista = repositorio.findAll();
        return lista.stream().map(c -> mapper.map(c, CitaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> findAllCustom() {
        List<CitaEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(c -> mapper.map(c, CitaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CitaDTO findById(Long id) {
        CitaEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, CitaDTO.class);
    }

    @Override
    public CitaDTO add(CitaDTO t) {
        CitaEntity cita = mapper.map(t, CitaEntity.class);
        return mapper.map(repositorio.save(cita), CitaDTO.class);
    }

    @Override
    public CitaDTO update(CitaDTO t, Long id) {
        CitaEntity cita = repositorio.findById(id).get();
        mapper.map(t, cita);
        return mapper.map(repositorio.save(cita), CitaDTO.class);
    }

    @Override
    public CitaDTO delete(Long id) {
        CitaEntity cita = repositorio.findById(id).get();
        cita.setEstado("Eliminado");
        return mapper.map(repositorio.save(cita), CitaDTO.class);
    }

    @Override
    public CitaDTO enable(Long id) {
        CitaEntity cita = repositorio.findById(id).get();
        cita.setEstado("Inhabilitado");
        return mapper.map(repositorio.save(cita), CitaDTO.class);
    }

    @Override
    public boolean existsByDate(Date date) {
        return repositorio.existsByDate(date);
    }
}
