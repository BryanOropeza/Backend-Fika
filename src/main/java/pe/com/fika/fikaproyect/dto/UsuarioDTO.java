package pe.com.fika.fikaproyect.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
@JsonPropertyOrder({ "codigo", "user", "email", "password", "estate", "rol_id", "paciente" })
public class UsuarioDTO extends GenericoDTO {
    private String user;

    @Email
    @NotBlank
    private String email;
    private String password;
    private String estate;
    private Set<String> roles;
    private PacienteEntity paciente;

}
