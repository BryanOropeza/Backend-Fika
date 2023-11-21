package pe.com.fika.fikaproyect.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.fika.fikaproyect.model.CitaEntity;

public interface CitaRepository extends JpaRepository<CitaEntity, Long> {

    @Query("select c from CitaEntity c where c.estado='Activo'")
    List<CitaEntity> findAllCustom();

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM CitaEntity c WHERE c.fechahora = :date")
    boolean existsByDate(@Param("date") Date date);
}
