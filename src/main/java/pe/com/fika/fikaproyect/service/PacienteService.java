package pe.com.fika.fikaproyect.service;

import pe.com.fika.fikaproyect.dto.PacienteDTO;
import pe.com.fika.fikaproyect.service.generico.GenericoService;

public interface PacienteService extends GenericoService<PacienteDTO> {

    public PacienteDTO crearPaciente(Long usuarioId, PacienteDTO pacienteDTO);

}
