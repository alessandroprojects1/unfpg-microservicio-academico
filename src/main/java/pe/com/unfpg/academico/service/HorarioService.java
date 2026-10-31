package pe.com.unfpg.academico.service;

import java.util.List;
import pe.com.unfpg.academico.entity.HorarioEntity;

public interface HorarioService {
    List<HorarioEntity> findAll();
    List<HorarioEntity> findAllCustom();
    HorarioEntity findById(Long id);
    HorarioEntity add(HorarioEntity obj);
    HorarioEntity update(HorarioEntity obj, Long id);

}