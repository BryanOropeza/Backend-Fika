package pe.com.fika.fikaproyect.model;

import java.io.Serializable;

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

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "UsuarioEntity")
@Table(name = "usuario")
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({ "codigo", "nombre", "correo", "contraseña", "estado", "rolid" })
public class UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nombre")
    private String nombre;
    private String correo;
    private String contraseña;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private RolEntity rolid;
}
