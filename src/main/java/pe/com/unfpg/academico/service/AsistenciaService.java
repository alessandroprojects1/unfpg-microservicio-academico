package pe.com.unfpg.academico.service;

import java.util.List;

import pe.com.unfpg.academico.entity.AsistenciaEntity;

public interface AsistenciaService {

	List<AsistenciaEntity> findAll();

	List<AsistenciaEntity> findAllCustom();

	AsistenciaEntity findById(Long id);

	AsistenciaEntity add(AsistenciaEntity obj);

	AsistenciaEntity update(AsistenciaEntity obj, Long id);

	AsistenciaEntity delete(Long id);
}