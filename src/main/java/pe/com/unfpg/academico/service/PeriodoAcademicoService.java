package pe.com.unfpg.academico.service;
import java.util.List;
import pe.com.unfpg.academico.entity.FacultadEntity;
import pe.com.unfpg.academico.entity.PeriodoAcademicoEntity;

public interface PeriodoAcademicoService {
	//declaramos las operaciones con las cuales vamosa trabajar
	//mostrar todos distrito
	List<PeriodoAcademicoEntity> findAll();
	//mostrar los distritos habilitados
	List<PeriodoAcademicoEntity> findAllCustom();
	//buscar distrito por codigo
	PeriodoAcademicoEntity findById(Long id);
	//registrar distrito
	PeriodoAcademicoEntity add(PeriodoAcademicoEntity obj);
	//actualizar distrito
	PeriodoAcademicoEntity update(PeriodoAcademicoEntity obj, Long id);
	//eliminar distrito
	PeriodoAcademicoEntity delete(Long id);
	//habilitar distrito
	PeriodoAcademicoEntity enable(Long id);
}
