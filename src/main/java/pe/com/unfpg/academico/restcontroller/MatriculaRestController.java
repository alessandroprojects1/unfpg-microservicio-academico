package pe.com.unfpg.academico.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.unfpg.academico.entity.MatriculaEntity;
import pe.com.unfpg.academico.service.MatriculaService;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaRestController {

	@Autowired
	private MatriculaService servicio;

	@GetMapping
	public List<MatriculaEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<MatriculaEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public MatriculaEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public MatriculaEntity add(@RequestBody MatriculaEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public MatriculaEntity update(@RequestBody MatriculaEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public MatriculaEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public MatriculaEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
