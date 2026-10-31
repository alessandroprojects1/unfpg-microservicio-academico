package pe.com.unfpg.academico.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.unfpg.academico.entity.FacultadEntity;
import pe.com.unfpg.academico.repository.FacultadRepository;
import pe.com.unfpg.academico.service.FacultadService;
//indicamos que es un servicio @Service
@Service
//implementamos el servicio
public class FacultadServiceImpl implements FacultadService {
	
	//inyeccion de dependencia hacia el repositorio
	private final FacultadRepository repositorio;

	FacultadServiceImpl(FacultadRepository repositorio) {
		this.repositorio = repositorio;
	}
	@Override
	public List<FacultadEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<FacultadEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public FacultadEntity findById(Long id) {
		return repositorio.findById(id).get();
	}
	@Override
	public FacultadEntity add(FacultadEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public FacultadEntity update(FacultadEntity obj, Long id) {
		//buscar el valor que se va actualizar
		FacultadEntity objdis=repositorio.findById(id).get();
		//actualizamos los valores
		BeanUtils.copyProperties(obj, objdis);
		return repositorio.save(objdis);
	}
	@Override
	public FacultadEntity delete(Long id) {
		//buscar el valor que se va actualizar
		FacultadEntity objdis=repositorio.findById(id).get();
		//cambiamos el estado
		objdis.setEstado(false);
		return repositorio.save(objdis);
	}
	@Override
	public FacultadEntity enable(Long id) {
		//buscar el valor que se va actualizar
		FacultadEntity objdis=repositorio.findById(id).get();
		//cambiamos el estado
		objdis.setEstado(true);
		return repositorio.save(objdis);
	}
}


