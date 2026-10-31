package pe.com.unfpg.academico.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.academico.entity.SeccionEntity;
import pe.com.unfpg.academico.service.SeccionService;

@RestController
@RequestMapping("/api/seccion")
public class SeccionRestController {

    @Autowired
    private SeccionService servicio;

    @GetMapping
    public List<SeccionEntity> findAll() { return servicio.findAll(); }

    @GetMapping("/custom")
    public List<SeccionEntity> findAllCustom() { return servicio.findAllCustom(); }

    @GetMapping("/{id}")
    public SeccionEntity findById(@PathVariable Long id) { return servicio.findById(id); }

    @PostMapping
    public SeccionEntity add(@RequestBody SeccionEntity obj) { return servicio.add(obj); }

    @PutMapping("/{id}")
    public SeccionEntity update(@RequestBody SeccionEntity obj, @PathVariable Long id) {
        return servicio.update(obj, id);
    }

    
}