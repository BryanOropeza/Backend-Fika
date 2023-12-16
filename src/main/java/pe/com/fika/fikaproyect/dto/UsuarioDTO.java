package pe.com.fika.fikaproyect.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.fika.fikaproyect.dto.generico.GenericoDTO;
import pe.com.fika.fikaproyect.model.PacienteEntity;
import pe.com.fika.fikaproyect.model.RolEntity;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({ "codigo", "user", "email", "password", "estate", "rol_id", "paciente" })
public class UsuarioDTO extends GenericoDTO {
    private String user;
    private String email;
    private String password;
    private String estate;
    private RolEntity rol_id;
    private PacienteEntity paciente;

}
