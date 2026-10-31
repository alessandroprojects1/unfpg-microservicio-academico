package pe.com.unfpg.academico.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.academico.entity.TrasladoEntity;
import pe.com.unfpg.academico.repository.TrasladoRepository;
import pe.com.unfpg.academico.service.TrasladoService;

@Service
public class TrasladoServiceImpl implements TrasladoService {

	private final TrasladoRepository repositorio;

	TrasladoServiceImpl(TrasladoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TrasladoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TrasladoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TrasladoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public TrasladoEntity add(TrasladoEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public TrasladoEntity update(TrasladoEntity obj, Long id) {
		// buscar el valor que se va a actualizar
		TrasladoEntity objtra = repositorio.findById(id).get();
		// actualizamos los valores, sin pisar el codigo
		BeanUtils.copyProperties(obj, objtra, "codigo");
		return repositorio.save(objtra);
	}

	@Override
	public TrasladoEntity delete(Long id) {
		// borrado logico: cambiamos el estado
		TrasladoEntity objtra = repositorio.findById(id).get();
		objtra.setEstado(false);
		return repositorio.save(objtra);
	}

	@Override
	public TrasladoEntity enable(Long id) {
		// habilitar: cambiamos el estado
		TrasladoEntity objtra = repositorio.findById(id).get();
		objtra.setEstado(true);
		return repositorio.save(objtra);
	}
}