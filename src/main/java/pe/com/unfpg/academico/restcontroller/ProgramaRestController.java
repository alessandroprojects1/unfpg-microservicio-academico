package pe.com.unfpg.academico.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.academico.entity.ProgramaEntity;
import pe.com.unfpg.academico.service.ProgramaService;

@RestController
@RequestMapping("/api/programa")
public class ProgramaRestController {

    @Autowired
    private ProgramaService servicio;

    @GetMapping
    public List<ProgramaEntity> findAll() { return servicio.findAll(); }

    @GetMapping("/custom")
    public List<ProgramaEntity> findAllCustom() { return servicio.findAllCustom(); }

    @GetMapping("/{id}")
    public ProgramaEntity findById(@PathVariable Long id) { return servicio.findById(id); }

    @PostMapping
    public ProgramaEntity add(@RequestBody ProgramaEntity obj) { return servicio.add(obj); }

    @PutMapping("/{id}")
    public ProgramaEntity update(@RequestBody ProgramaEntity obj, @PathVariable Long id) {
        return servicio.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public ProgramaEntity delete(@PathVariable Long id) { return servicio.delete(id); }

    @PatchMapping("/{id}")
    public ProgramaEntity enable(@PathVariable Long id) { return servicio.enable(id); }
}