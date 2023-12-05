package pe.com.fika.fikaproyect.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        "codigo", "dni", "nombre", "apellido", "direccion", "telefono", "fechanacimiento", "estado", "sexo",
        "observaciones" })
@EqualsAndHashCode(callSuper = false)
@Entity(name = "PacienteEntity")
@Table(name = "paciente")
public class PacienteEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_paciente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "dni")
    private String dni;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "fecha_nacimiento")
    private Date fechanacimiento;
    @Column(name = "estado")
    private String estado;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "observaciones")
    private String observaciones;

}
