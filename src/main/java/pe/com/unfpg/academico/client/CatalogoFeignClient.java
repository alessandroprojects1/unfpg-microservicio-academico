package pe.com.unfpg.academico.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "unfpg-microservicio-catalogo", url = "http://localhost:9091/unfpg/api")
public interface CatalogoFeignClient {

    @GetMapping("/bloque/{id}")
    Object getBloque(@PathVariable("id") Long id);

    @GetMapping("/diasemana/{id}")
    Object getDiaSemana(@PathVariable("id") Long id);

    @GetMapping("/tipoaula/{id}")
    Object getTipoAula(@PathVariable("id") Long id);

    @GetMapping("/ubicacion/{id}")
    Object getUbicacion(@PathVariable("id") Long id);
    
    @GetMapping("/estadoaula/{id}")
    Object getEstadoAula(@PathVariable("id") Long id);
    
    @GetMapping("/estadomatricula/{id}")
    Object getEstadoMatricula(@PathVariable("id") Long id);
    
    @GetMapping("/tipomatricula/{id}")
    Object getTipoMatricula(@PathVariable("id") Long id);
    
    @GetMapping("/tipocalificacion/{id}")
    Object getTipoCalificacion(@PathVariable("id") Long id);
    
    
   
    
}