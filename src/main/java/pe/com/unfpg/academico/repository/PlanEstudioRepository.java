package pe.com.unfpg.academico.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.unfpg.academico.entity.PlanEstudioEntity;

public interface PlanEstudioRepository extends JpaRepository<PlanEstudioEntity, Long> {

    @Query("select p from PlanEstudioEntity p where p.estado = true")
    List<PlanEstudioEntity> findAllCustom();
}