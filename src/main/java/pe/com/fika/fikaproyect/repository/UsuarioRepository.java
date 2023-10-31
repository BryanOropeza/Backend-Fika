package pe.com.fika.fikaproyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.fika.fikaproyect.model.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query("select u from UsuarioEntity u where u.estate='Activo'")
    List<UsuarioEntity> findAllCustom();

    @Query("select u from UsuarioEntity u where u.estate='Activo' and u.password = :password and u.user = :user")
    UsuarioEntity login(@Param("user") String username, @Param("password") String password);
}
