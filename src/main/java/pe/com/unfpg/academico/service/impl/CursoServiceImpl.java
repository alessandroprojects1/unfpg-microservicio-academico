package pe.com.unfpg.academico.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.unfpg.academico.entity.CursoEntity;
import pe.com.unfpg.academico.repository.CursoRepository;
import pe.com.unfpg.academico.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repositorio;

    CursoServiceImpl(CursoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<CursoEntity> findAll() { return repositorio.findAll(); }

    @Override
    public List<CursoEntity> findAllCustom() { return repositorio.findAllCustom(); }

    @Override
    public CursoEntity findById(Long id) { return repositorio.findById(id).get(); }

    @Override
    public CursoEntity add(CursoEntity obj) { return repositorio.save(obj); }

    @Override
    public CursoEntity update(CursoEntity obj, Long id) {
        CursoEntity objcur = repositorio.findById(id).get();
        BeanUtils.copyProperties(obj, objcur);
        return repositorio.save(objcur);
    }

   
}