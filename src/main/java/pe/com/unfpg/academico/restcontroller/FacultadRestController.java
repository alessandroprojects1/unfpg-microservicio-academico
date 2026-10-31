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
import pe.com.unfpg.academico.entity.FacultadEntity;
import pe.com.unfpg.academico.service.FacultadService;
//servicio RESTful
@RestController
//definir la ruta
@RequestMapping("/api/facultad")
public class FacultadRestController {
	//inyeccion de dependencias hacia el servicio
	@Autowired
	private FacultadService servicio;
	
	//Consultas o busquedas -> @GetMapping
	//mostrar todos los distritos
	@GetMapping
	public List<FacultadEntity> findAll(){
		return servicio.findAll();
	}
	
	//mostrar los distritos habilitados
	@GetMapping("/custom")
	public List<FacultadEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	//buscar distrito por codigo
	//{id} -> variable de ruta
	@GetMapping("/{id}")
	public FacultadEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	//registrar -> @PostMapping
	//registrar distrito
	@PostMapping
	public FacultadEntity add(@RequestBody FacultadEntity obj) {
		return servicio.add(obj);
	}
	
	//actualizar -> @PutMapping
	//actualizar distrito
	@PutMapping("/{id}")
	public FacultadEntity update(@RequestBody FacultadEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	//eliminar -> @DeleteMapping
	//eliminar distrito
	@DeleteMapping("/{id}")
	public FacultadEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	//habilitar -> actualizar parcial -> @PatchMapping
	//habilitar distrito
	@PatchMapping("/{id}")
	public FacultadEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
