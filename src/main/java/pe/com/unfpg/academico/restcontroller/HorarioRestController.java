package pe.com.unfpg.academico.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.unfpg.academico.entity.HorarioEntity;
import pe.com.unfpg.academico.service.HorarioService;

@RestController
@RequestMapping("/api/horario")
public class HorarioRestController {

    @Autowired
    private HorarioService servicio;

    @GetMapping
    public List<HorarioEntity> findAll() { return servicio.findAll(); }

    @GetMapping("/custom")
    public List<HorarioEntity> findAllCustom() { return servicio.findAllCustom(); }

    @GetMapping("/{id}")
    public HorarioEntity findById(@PathVariable Long id) { return servicio.findById(id); }

    @PostMapping
    public HorarioEntity add(@RequestBody HorarioEntity obj) { return servicio.add(obj); }

    @PutMapping("/{id}")
    public HorarioEntity update(@RequestBody HorarioEntity obj, @PathVariable Long id) {
        return servicio.update(obj, id);
    }

   
}