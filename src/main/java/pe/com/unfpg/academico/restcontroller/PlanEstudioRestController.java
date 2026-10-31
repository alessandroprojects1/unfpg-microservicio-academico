package pe.com.unfpg.academico.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.academico.entity.PlanEstudioEntity;
import pe.com.unfpg.academico.service.PlanEstudioService;

@RestController
@RequestMapping("/api/planestudio")
public class PlanEstudioRestController {

    @Autowired
    private PlanEstudioService servicio;

    @GetMapping
    public List<PlanEstudioEntity> findAll() { return servicio.findAll(); }

    @GetMapping("/custom")
    public List<PlanEstudioEntity> findAllCustom() { return servicio.findAllCustom(); }

    @GetMapping("/{id}")
    public PlanEstudioEntity findById(@PathVariable Long id) { return servicio.findById(id); }

    @PostMapping
    public PlanEstudioEntity add(@RequestBody PlanEstudioEntity obj) { return servicio.add(obj); }

    @PutMapping("/{id}")
    public PlanEstudioEntity update(@RequestBody PlanEstudioEntity obj, @PathVariable Long id) {
        return servicio.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public PlanEstudioEntity delete(@PathVariable Long id) { return servicio.delete(id); }

    @PatchMapping("/{id}")
    public PlanEstudioEntity enable(@PathVariable Long id) { return servicio.enable(id); }
}