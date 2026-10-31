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

import pe.com.unfpg.academico.entity.DetalleMatriculaEntity;
import pe.com.unfpg.academico.service.DetalleMatriculaService;

@RestController
@RequestMapping("/api/detallematricula")
public class DetalleMatriculaRestController {

	@Autowired
	private DetalleMatriculaService servicio;

	@GetMapping
	public List<DetalleMatriculaEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<DetalleMatriculaEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public DetalleMatriculaEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public DetalleMatriculaEntity add(@RequestBody DetalleMatriculaEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public DetalleMatriculaEntity update(@RequestBody DetalleMatriculaEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public DetalleMatriculaEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public DetalleMatriculaEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}