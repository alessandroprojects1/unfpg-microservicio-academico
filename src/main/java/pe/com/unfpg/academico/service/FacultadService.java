package pe.com.unfpg.academico.service;
import java.util.List;
import pe.com.unfpg.academico.entity.FacultadEntity;
public interface FacultadService {
	//declaramos las operaciones con las cuales vamosa trabajar
	//mostrar todos distrito
	List<FacultadEntity> findAll();
	//mostrar los distritos habilitados
	List<FacultadEntity> findAllCustom();
	//buscar distrito por codigo
	FacultadEntity findById(Long id);
	//registrar distrito
	FacultadEntity add(FacultadEntity obj);
	//actualizar distrito
	FacultadEntity update(FacultadEntity obj, Long id);
	//eliminar distrito
	FacultadEntity delete(Long id);
	//habilitar distrito
	FacultadEntity enable(Long id);
}
