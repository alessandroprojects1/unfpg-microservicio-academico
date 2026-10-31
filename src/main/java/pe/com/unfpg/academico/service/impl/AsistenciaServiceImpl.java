package pe.com.unfpg.academico.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.academico.entity.AsistenciaEntity;
import pe.com.unfpg.academico.repository.AsistenciaRepository;
import pe.com.unfpg.academico.service.AsistenciaService;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {

	private final AsistenciaRepository repositorio;

	AsistenciaServiceImpl(AsistenciaRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<AsistenciaEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<AsistenciaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public AsistenciaEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public AsistenciaEntity add(AsistenciaEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public AsistenciaEntity update(AsistenciaEntity obj, Long id) {
		// buscar el registro que se va a actualizar
		AsistenciaEntity objasis = repositorio.findById(id).get();
		// copiar los valores, sin pisar el codigo
		BeanUtils.copyProperties(obj, objasis, "codigo");
		return repositorio.save(objasis);
	}

	@Override
	public AsistenciaEntity delete(Long id) {
		// no hay campo estado, asi que se elimina el registro
		AsistenciaEntity objasis = repositorio.findById(id).get();
		repositorio.deleteById(id);
		return objasis;
	}
}