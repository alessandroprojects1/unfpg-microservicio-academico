package pe.com.unfpg.academico.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.unfpg.academico.entity.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {

    @Query("select c from CursoEntity c")
    List<CursoEntity> findAllCustom();
}