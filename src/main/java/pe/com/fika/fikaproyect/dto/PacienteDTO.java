package pe.com.fika.fikaproyect.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.fika.fikaproyect.dto.generico.GenericoDTO;
import pe.com.fika.fikaproyect.model.UsuarioEntity;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({ "codigo", "dni", "nombre", "apellido", "direccion", "telefono", "fechanacimiento", "estado",
        "sexo",
        "observaciones" })
public class PacienteDTO extends GenericoDTO {
    private String nombre;
    private String dni;
    private String apellido;
    private String direccion;
    private String telefono;
    private Date fechanacimiento;
    private String estado;
    private String sexo;
    private String observaciones;
}
