package pe.com.unfpg.academico.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.unfpg.academico.entity.ProgramaEntity;

public interface ProgramaRepository extends JpaRepository<ProgramaEntity, Long> {

    @Query("select p from ProgramaEntity p where p.estado = true")
    List<ProgramaEntity> findAllCustom();
}