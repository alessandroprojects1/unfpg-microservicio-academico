package pe.com.unfpg.academico.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.unfpg.academico.entity.PeriodoAcademicoEntity;

public interface PeriodoAcademicoRepository extends JpaRepository<PeriodoAcademicoEntity, Long> {
	//utilizamos el JpaRepository por defecto se configura:
	//mostrar, buscar por codigo, registrar, actualizar y eliminar
	
	//agregamos un Query personalizado
	//Consulta MySQL: select * from distrito where estdis=1
	//creamos un query personalizado
	@Query("select s from PeriodoAcademicoEntity s where s.estado=true")
	List<PeriodoAcademicoEntity> findAllCustom();
}
