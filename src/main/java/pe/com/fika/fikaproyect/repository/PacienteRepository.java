package pe.com.fika.fikaproyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.fika.fikaproyect.model.PacienteEntity;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

    @Query("select p from PacienteEntity p where p.estado='Activo'")
    List<PacienteEntity> findAllCustom();
}
