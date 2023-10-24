package pe.com.fika.fikaproyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.fika.fikaproyect.model.CitaEntity;

public interface CitaRepository extends JpaRepository<CitaEntity, Long> {

    @Query("select c from CitaEntity c where c.estado='Activo'")
    List<CitaEntity> findAllCustom();
}
