package pe.com.unfpg.academico.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.unfpg.academico.entity.AulaEntity;

public interface AulaRepository extends JpaRepository<AulaEntity, Long> {

    // Trae aulas con estadoaula id=1 (DISPONIBLE)
    @Query("select a from AulaEntity a where a.codesta = 1")
    List<AulaEntity> findAllCustom();
}