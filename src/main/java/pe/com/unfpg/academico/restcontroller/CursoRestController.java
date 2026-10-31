package pe.com.unfpg.academico.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.academico.entity.CursoEntity;
import pe.com.unfpg.academico.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoRestController {

    @Autowired
    private CursoService servicio;

    @GetMapping
    public List<CursoEntity> findAll() { return servicio.findAll(); }

    @GetMapping("/custom")
    public List<CursoEntity> findAllCustom() { return servicio.findAllCustom(); }

    @GetMapping("/{id}")
    public CursoEntity findById(@PathVariable Long id) { return servicio.findById(id); }

    @PostMapping
    public CursoEntity add(@RequestBody CursoEntity obj) { return servicio.add(obj); }

    @PutMapping("/{id}")
    public CursoEntity update(@RequestBody CursoEntity obj, @PathVariable Long id) {
        return servicio.update(obj, id);
    }

  
}