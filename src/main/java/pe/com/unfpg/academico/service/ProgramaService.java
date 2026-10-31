package pe.com.unfpg.academico.service;

import java.util.List;
import pe.com.unfpg.academico.entity.ProgramaEntity;

public interface ProgramaService {
    List<ProgramaEntity> findAll();
    List<ProgramaEntity> findAllCustom();
    ProgramaEntity findById(Long id);
    ProgramaEntity add(ProgramaEntity obj);
    ProgramaEntity update(ProgramaEntity obj, Long id);
    ProgramaEntity delete(Long id);
    ProgramaEntity enable(Long id);
}