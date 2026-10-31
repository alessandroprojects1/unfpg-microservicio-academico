package pe.com.unfpg.academico.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.academico.client.CatalogoFeignClient;
import pe.com.unfpg.academico.entity.AulaEntity;
import pe.com.unfpg.academico.repository.AulaRepository;
import pe.com.unfpg.academico.service.AulaService;

@Service
public class AulaServiceImpl implements AulaService {

    private final AulaRepository repositorio;
    private final CatalogoFeignClient catalogoFeignClient;

    public AulaServiceImpl(AulaRepository repositorio,
                           CatalogoFeignClient catalogoFeignClient) {
        this.repositorio = repositorio;
        this.catalogoFeignClient = catalogoFeignClient;
    }

    // Llena los campos temporales con los datos del microservicio Catálogo
    private AulaEntity completar(AulaEntity aula) {
        aula.setTipoaula(catalogoFeignClient.getTipoAula(aula.getCodtipa()));
        aula.setUbicacion(catalogoFeignClient.getUbicacion(aula.getCodubi()));
        return aula;
    }

    @Override
    public List<AulaEntity> findAll() {
        List<AulaEntity> aulas = repositorio.findAll();
        aulas.forEach(this::completar);
        return aulas;
    }

    @Override
    public List<AulaEntity> findAllCustom() {
        List<AulaEntity> aulas = repositorio.findAllCustom();
        aulas.forEach(this::completar);
        return aulas;
    }

    @Override
    public AulaEntity findById(Long id) {
        return completar(repositorio.findById(id).get());
    }

    @Override
    public AulaEntity add(AulaEntity obj) {
        return repositorio.save(obj);
    }

    @Override
    public AulaEntity update(AulaEntity obj, Long id) {
        AulaEntity objaula = repositorio.findById(id).get();
        BeanUtils.copyProperties(obj, objaula, "codigo");
        return repositorio.save(objaula);
    }

    @Override
    public AulaEntity delete(Long id) {
        // Estado "MANTENIMIENTO" = codesta 3 (ajusta según tus datos)
        AulaEntity objaula = repositorio.findById(id).get();
        objaula.setCodesta(3L);
        return repositorio.save(objaula);
    }

    @Override
    public AulaEntity enable(Long id) {
        // Estado "DISPONIBLE" = codesta 1 (ajusta según tus datos)
        AulaEntity objaula = repositorio.findById(id).get();
        objaula.setCodesta(1L);
        return repositorio.save(objaula);
    }
}