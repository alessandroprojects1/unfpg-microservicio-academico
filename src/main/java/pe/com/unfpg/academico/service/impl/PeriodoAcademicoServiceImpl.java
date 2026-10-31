package pe.com.unfpg.academico.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.unfpg.academico.entity.PeriodoAcademicoEntity;
import pe.com.unfpg.academico.repository.PeriodoAcademicoRepository;
import pe.com.unfpg.academico.service.PeriodoAcademicoService;
//indicamos que es un servicio @Service
@Service
//implementamos el servicio
public class PeriodoAcademicoServiceImpl implements PeriodoAcademicoService {
	
	//inyeccion de dependencia hacia el repositorio
	private final PeriodoAcademicoRepository repositorio;

	PeriodoAcademicoServiceImpl(PeriodoAcademicoRepository repositorio) {
		this.repositorio = repositorio;
	}
	@Override
	public List<PeriodoAcademicoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<PeriodoAcademicoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public PeriodoAcademicoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public PeriodoAcademicoEntity add(PeriodoAcademicoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public PeriodoAcademicoEntity update(PeriodoAcademicoEntity obj, Long id) {
		//buscar el valor que se va actualizar
		PeriodoAcademicoEntity objdis=repositorio.findById(id).get();
		//actualizamos los valores
		BeanUtils.copyProperties(obj, objdis);
		return repositorio.save(objdis);
	}
	@Override
	public PeriodoAcademicoEntity delete(Long id) {
		//buscar el valor que se va actualizar
		PeriodoAcademicoEntity objdis=repositorio.findById(id).get();
		//cambiamos el estado
		objdis.setEstado(false);
		return repositorio.save(objdis);
	}
	@Override
	public PeriodoAcademicoEntity enable(Long id) {
		//buscar el valor que se va actualizar
		PeriodoAcademicoEntity objdis=repositorio.findById(id).get();
		//cambiamos el estado
		objdis.setEstado(true);
		return repositorio.save(objdis);
	}
}



