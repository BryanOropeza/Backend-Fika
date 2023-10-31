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
@JsonPropertyOrder({ "codigo", "user", "email", "password", "estate", "rol_id" })
public class UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nombre_usr")
    private String user;
    @Column(name = "correo")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "estado")
    private String estate;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private RolEntity rol_id;
}
