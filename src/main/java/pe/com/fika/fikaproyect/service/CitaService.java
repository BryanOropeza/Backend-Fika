package pe.com.fika.fikaproyect.service;

import java.util.Date;

import pe.com.fika.fikaproyect.dto.CitaDTO;
import pe.com.fika.fikaproyect.service.generico.GenericoService;

public interface CitaService extends GenericoService<CitaDTO> {

    boolean existsByDate(Date date);

}
