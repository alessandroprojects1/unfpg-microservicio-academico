package pe.com.unfpg.academico.service;

import java.util.List;

import pe.com.unfpg.academico.entity.DetalleMatriculaEntity;

public interface DetalleMatriculaService {
	List<DetalleMatriculaEntity> findAll();
	List<DetalleMatriculaEntity> findAllCustom();
	DetalleMatriculaEntity findById(Long id);
	DetalleMatriculaEntity add(DetalleMatriculaEntity obj);
	DetalleMatriculaEntity update(DetalleMatriculaEntity obj, Long id);
	DetalleMatriculaEntity delete(Long id);
	DetalleMatriculaEntity enable(Long id);
}
