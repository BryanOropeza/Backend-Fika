package pe.com.fika.fikaproyect.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.fika.fikaproyect.dto.generico.GenericoDTO;
import pe.com.fika.fikaproyect.model.PacienteEntity;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({ "codigo", "fechahora", "tratamiento", "estado", "pacienteid", "observaciones" })
public class CitaDTO extends GenericoDTO {
    private Date fechahora;
    private String tratamiento;
    private String estado;
    private PacienteEntity pacienteid;
    private String observaciones;
}
