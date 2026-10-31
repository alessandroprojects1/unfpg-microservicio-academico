package pe.com.unfpg.academico.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.academico.entity.DetalleMatriculaEntity;
import pe.com.unfpg.academico.repository.DetalleMatriculaRepository;
import pe.com.unfpg.academico.service.DetalleMatriculaService;

@Service
public class DetalleMatriculaServiceImpl implements DetalleMatriculaService {

	private final DetalleMatriculaRepository repositorio;

	DetalleMatriculaServiceImpl(DetalleMatriculaRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<DetalleMatriculaEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<DetalleMatriculaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public DetalleMatriculaEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public DetalleMatriculaEntity add(DetalleMatriculaEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}

	@Override
	public DetalleMatriculaEntity update(DetalleMatriculaEntity obj, Long id) {
		DetalleMatriculaEntity objdet = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdet, "codigo");
		return repositorio.save(objdet);
	}

	@Override
	public DetalleMatriculaEntity delete(Long id) {
		DetalleMatriculaEntity objdet = repositorio.findById(id).get();
		objdet.setEstado(false);
		return repositorio.save(objdet);
	}

	@Override
	public DetalleMatriculaEntity enable(Long id) {
		DetalleMatriculaEntity objdet = repositorio.findById(id).get();
		objdet.setEstado(true);
		return repositorio.save(objdet);
	}
}