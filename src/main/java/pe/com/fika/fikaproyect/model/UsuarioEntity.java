package pe.com.fika.fikaproyect.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@JsonPropertyOrder({ "codigo", "user", "email", "password", "estate", "rol_id", "paciente" })
public class UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "nombre_usr")
    @NotBlank
    @Size(max = 80)
    private String user;

    @Column(name = "correo")
    @Email
    @NotBlank
    @Size(max = 80)
    private String email;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "estado")
    @NotBlank
    private String estate;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private RolEntity rol_id;

    @JsonBackReference
    @OneToOne(mappedBy = "usuario")
    private PacienteEntity paciente;

}
