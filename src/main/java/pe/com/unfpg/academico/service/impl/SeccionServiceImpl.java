package pe.com.unfpg.academico.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.unfpg.academico.client.PersonasFeignClient;
import pe.com.unfpg.academico.entity.SeccionEntity;
import pe.com.unfpg.academico.repository.SeccionRepository;
import pe.com.unfpg.academico.service.SeccionService;

@Service
public class SeccionServiceImpl implements SeccionService {

    private final SeccionRepository repositorio;
    private final PersonasFeignClient personasFeignClient;

    public SeccionServiceImpl(SeccionRepository repositorio,
                              PersonasFeignClient personasFeignClient) {
        this.repositorio = repositorio;
        this.personasFeignClient = personasFeignClient;
    }

    private SeccionEntity completar(SeccionEntity seccion) {
        seccion.setDocente(personasFeignClient.getDocente(seccion.getCoddoc()));
        return seccion;
    }

    @Override
    public List<SeccionEntity> findAll() {
        List<SeccionEntity> secciones = repositorio.findAll();
        secciones.forEach(this::completar);
        return secciones;
    }

    @Override
    public List<SeccionEntity> findAllCustom() {
        List<SeccionEntity> secciones = repositorio.findAllCustom();
        secciones.forEach(this::completar);
        return secciones;
    }

    @Override
    public SeccionEntity findById(Long id) {
        return completar(repositorio.findById(id).get());
    }

    @Override
    public SeccionEntity add(SeccionEntity obj) {
        return repositorio.save(obj);
    }

    @Override
    public SeccionEntity update(SeccionEntity obj, Long id) {
        SeccionEntity objsec = repositorio.findById(id).get();
        BeanUtils.copyProperties(obj, objsec, "codigo");
        return repositorio.save(objsec);
    }
}