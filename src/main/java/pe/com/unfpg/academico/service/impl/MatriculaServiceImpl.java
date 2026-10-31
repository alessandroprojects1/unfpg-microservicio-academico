package pe.com.unfpg.academico.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.academico.client.CatalogoFeignClient;
import pe.com.unfpg.academico.client.PersonasFeignClient;
import pe.com.unfpg.academico.entity.MatriculaEntity;
import pe.com.unfpg.academico.repository.MatriculaRepository;
import pe.com.unfpg.academico.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	private final MatriculaRepository repositorio;
	private final CatalogoFeignClient catalogoFeignClient;
	private final PersonasFeignClient personasFeignClient;

	public MatriculaServiceImpl(MatriculaRepository repositorio,
			CatalogoFeignClient catalogoFeignClient,
			PersonasFeignClient personasFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
		this.personasFeignClient = personasFeignClient;
	}

	private MatriculaEntity completar(MatriculaEntity matricula) {
		matricula.setAlumno(personasFeignClient.getAlumno(matricula.getCodalu()));
		matricula.setEstadomatricula(catalogoFeignClient.getEstadoMatricula(matricula.getCodestm()));
		matricula.setTipomatricula(catalogoFeignClient.getTipoMatricula(matricula.getCodtipm()));
		return matricula;
	}

	@Override
	public List<MatriculaEntity> findAll() {
		List<MatriculaEntity> matriculas = repositorio.findAll();
		matriculas.forEach(this::completar);
		return matriculas;
	}

	@Override
	public List<MatriculaEntity> findAllCustom() {
		List<MatriculaEntity> matriculas = repositorio.findAllCustom();
		matriculas.forEach(this::completar);
		return matriculas;
	}

	@Override
	public MatriculaEntity findById(Long id) {
		return completar(repositorio.findById(id).get());
	}

	@Override
	public MatriculaEntity add(MatriculaEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}

	@Override
	public MatriculaEntity update(MatriculaEntity obj, Long id) {
		MatriculaEntity objmat = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objmat, "numero", "fecha", "estado");
		return repositorio.save(objmat);
	}

	@Override
	public MatriculaEntity delete(Long id) {
		MatriculaEntity objmat = repositorio.findById(id).get();
		objmat.setEstado(false);
		return repositorio.save(objmat);
	}

	@Override
	public MatriculaEntity enable(Long id) {
		MatriculaEntity objmat = repositorio.findById(id).get();
		objmat.setEstado(true);
		return repositorio.save(objmat);
	}
}