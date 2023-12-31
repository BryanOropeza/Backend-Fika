package pe.com.fika.fikaproyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.fika.fikaproyect.model.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Long> {

    @Query("select r from RolEntity r where r.estado='Activo'")
    List<RolEntity> findAllCustom();
}
