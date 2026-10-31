package pe.com.unfpg.academico.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.unfpg.academico.entity.AsistenciaEntity;
import pe.com.unfpg.academico.service.AsistenciaService;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaRestController {

	@Autowired
	private AsistenciaService servicio;

	@GetMapping
	public List<AsistenciaEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<AsistenciaEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public AsistenciaEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public AsistenciaEntity add(@RequestBody AsistenciaEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public AsistenciaEntity update(@RequestBody AsistenciaEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public AsistenciaEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
}