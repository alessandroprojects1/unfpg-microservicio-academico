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
import pe.com.unfpg.academico.entity.AulaEntity;
import pe.com.unfpg.academico.service.AulaService;

@RestController
@RequestMapping("/api/aula")
public class AulaRestController {

    @Autowired
    private AulaService servicio;

    @GetMapping
    public List<AulaEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<AulaEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public AulaEntity findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public AulaEntity add(@RequestBody AulaEntity obj) {
        return servicio.add(obj);
    }

    @PutMapping("/{id}")
    public AulaEntity update(@RequestBody AulaEntity obj,
            @PathVariable Long id) {
        return servicio.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public AulaEntity delete(@PathVariable Long id) {
        return servicio.delete(id);
    }

    @PatchMapping("/{id}")
    public AulaEntity enable(@PathVariable Long id) {
        return servicio.enable(id);
    }
}