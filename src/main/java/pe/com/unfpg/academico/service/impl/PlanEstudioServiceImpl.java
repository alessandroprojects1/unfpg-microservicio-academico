package pe.com.unfpg.academico.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.unfpg.academico.entity.PlanEstudioEntity;
import pe.com.unfpg.academico.repository.PlanEstudioRepository;
import pe.com.unfpg.academico.service.PlanEstudioService;

@Service
public class PlanEstudioServiceImpl implements PlanEstudioService {

    private final PlanEstudioRepository repositorio;

    PlanEstudioServiceImpl(PlanEstudioRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<PlanEstudioEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<PlanEstudioEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public PlanEstudioEntity findById(Long id) { return repositorio.findById(id).get(); }

    @Override
    public PlanEstudioEntity add(PlanEstudioEntity obj) {
        obj.setEstado(true);
        return repositorio.save(obj);
    }

    @Override
    public PlanEstudioEntity update(PlanEstudioEntity obj, Long id) {
        PlanEstudioEntity objpla = repositorio.findById(id).get();
        BeanUtils.copyProperties(obj, objpla);
        return repositorio.save(objpla);
    }

    @Override
    public PlanEstudioEntity delete(Long id) {
        PlanEstudioEntity objpla = repositorio.findById(id).get();
        objpla.setEstado(false);
        return repositorio.save(objpla);
    }

    @Override
    public PlanEstudioEntity enable(Long id) {
        PlanEstudioEntity objpla = repositorio.findById(id).get();
        objpla.setEstado(true);
        return repositorio.save(objpla);
    }
}