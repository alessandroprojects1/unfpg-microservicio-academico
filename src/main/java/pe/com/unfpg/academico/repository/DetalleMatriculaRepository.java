package pe.com.unfpg.academico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.unfpg.academico.entity.DetalleMatriculaEntity;

public interface DetalleMatriculaRepository extends JpaRepository<DetalleMatriculaEntity, Long> {

	@Query("select d from DetalleMatriculaEntity d where d.estado=true")
	List<DetalleMatriculaEntity> findAllCustom();
}
