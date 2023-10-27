package pe.com.fika.fikaproyect.model;

import java.io.Serializable;

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
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({ "codigo", "nombre", "estado" })
@Table(name = "rol")
@Entity(name = "RolEntity")
public class RolEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "est_rol")
    private String estado;
}
