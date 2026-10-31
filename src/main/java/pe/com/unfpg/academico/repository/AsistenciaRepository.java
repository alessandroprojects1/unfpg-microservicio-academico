package pe.com.unfpg.academico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.unfpg.academico.entity.AsistenciaEntity;

public interface AsistenciaRepository extends JpaRepository<AsistenciaEntity, Long> {

	// listado de la asistencia mas reciente a la mas antigua
	@Query("SELECT a FROM AsistenciaEntity a ORDER BY a.fecha DESC")
	List<AsistenciaEntity> findAllCustom();
}