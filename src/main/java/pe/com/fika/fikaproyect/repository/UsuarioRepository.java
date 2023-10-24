package pe.com.fika.fikaproyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.fika.fikaproyect.model.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query("select u from UsuarioEntity u where u.estado='Activo'")
    List<UsuarioEntity> findAllCustom();
}
