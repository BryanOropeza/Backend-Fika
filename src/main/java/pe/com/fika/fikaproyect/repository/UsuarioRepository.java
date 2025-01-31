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

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UsuarioEntity u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UsuarioEntity u WHERE u.user = :user")
    boolean existsByUser(@Param("user") String user);

    @Query("SELECT u FROM UsuarioEntity u WHERE u.user = :username")
    UsuarioEntity findByUsername(@Param("username") String username);

}
