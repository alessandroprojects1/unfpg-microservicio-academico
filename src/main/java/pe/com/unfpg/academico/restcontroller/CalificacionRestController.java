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

import pe.com.unfpg.academico.entity.CalificacionEntity;
import pe.com.unfpg.academico.service.CalificacionService;

@RestController
@RequestMapping("/api/calificacion")
public class CalificacionRestController {

	@Autowired
	private CalificacionService servicio;

	@GetMapping
	public List<CalificacionEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/{id}")
	public CalificacionEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public CalificacionEntity add(@RequestBody CalificacionEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public CalificacionEntity update(@RequestBody CalificacionEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public CalificacionEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
}