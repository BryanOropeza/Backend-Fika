package pe.com.fika.fikaproyect.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.fika.fikaproyect.dto.generico.GenericoDTO;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({ "codigo", "nombre", "estado" })
public class RolDTO extends GenericoDTO {
    private String nombre;
    private String estado;
}
