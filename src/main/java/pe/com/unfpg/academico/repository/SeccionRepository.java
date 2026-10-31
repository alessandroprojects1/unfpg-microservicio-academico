package pe.com.unfpg.academico.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.unfpg.academico.entity.SeccionEntity;

public interface SeccionRepository extends JpaRepository<SeccionEntity, Long> {

    @Query("select s from SeccionEntity s")
    List<SeccionEntity> findAllCustom();
}