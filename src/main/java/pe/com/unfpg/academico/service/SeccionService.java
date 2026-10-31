package pe.com.unfpg.academico.service;

import java.util.List;
import pe.com.unfpg.academico.entity.SeccionEntity;

public interface SeccionService {
    List<SeccionEntity> findAll();
    List<SeccionEntity> findAllCustom();
    SeccionEntity findById(Long id);
    SeccionEntity add(SeccionEntity obj);
    SeccionEntity update(SeccionEntity obj, Long id);
   
}