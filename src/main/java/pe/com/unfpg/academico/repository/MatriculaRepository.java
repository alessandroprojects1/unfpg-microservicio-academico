package pe.com.unfpg.academico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.unfpg.academico.entity.MatriculaEntity;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Long> {

	@Query("select m from MatriculaEntity m where m.estado=true")
	List<MatriculaEntity> findAllCustom();
}