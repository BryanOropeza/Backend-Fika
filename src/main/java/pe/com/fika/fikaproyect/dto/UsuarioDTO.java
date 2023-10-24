package pe.com.fika.fikaproyect.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.fika.fikaproyect.dto.generico.GenericoDTO;
import pe.com.fika.fikaproyect.model.RolEntity;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({ "codigo", "nombre", "correo", "contraseña", "estado", "rolid" })
public class UsuarioDTO extends GenericoDTO {
    private String nombre;
    private String correo;
    private String contraseña;
    private String estado;
    private RolEntity rolid;

}
