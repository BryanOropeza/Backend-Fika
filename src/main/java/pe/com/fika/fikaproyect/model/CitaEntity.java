package pe.com.fika.fikaproyect.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({ "codigo", "fechahora", "tratamiento", "estado", "pacienteid" })
@Entity(name = "CitaEntity")
@Table(name = "cita")
public class CitaEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_cita")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "fecha_hora")
    private Date fechahora;
    @Column(name = "tratamiento")
    private String tratamiento;
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteEntity pacienteid;

    @Column(name = "observaciones")
    private String observaciones;
}
