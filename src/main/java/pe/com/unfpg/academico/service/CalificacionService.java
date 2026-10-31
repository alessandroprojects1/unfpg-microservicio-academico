package pe.com.unfpg.academico.service;

import java.util.List;

import pe.com.unfpg.academico.entity.CalificacionEntity;

public interface CalificacionService {
	List<CalificacionEntity> findAll();
	CalificacionEntity findById(Long id);
	CalificacionEntity add(CalificacionEntity obj);
	CalificacionEntity update(CalificacionEntity obj, Long id);
	CalificacionEntity delete(Long id);
}