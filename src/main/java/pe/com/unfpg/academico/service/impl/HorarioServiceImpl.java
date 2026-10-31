package pe.com.unfpg.academico.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.com.unfpg.academico.client.CatalogoFeignClient;
import pe.com.unfpg.academico.entity.HorarioEntity;
import pe.com.unfpg.academico.repository.HorarioRepository;
import pe.com.unfpg.academico.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {

    private final HorarioRepository repositorio;
    private final CatalogoFeignClient catalogoFeignClient;

    public HorarioServiceImpl(HorarioRepository repositorio,
                              CatalogoFeignClient catalogoFeignClient) {
        this.repositorio = repositorio;
        this.catalogoFeignClient = catalogoFeignClient;
    }

    private HorarioEntity completar(HorarioEntity horario) {
        horario.setBloque(catalogoFeignClient.getBloque(horario.getCodblo()));
        horario.setDiasemana(catalogoFeignClient.getDiaSemana(horario.getCoddias()));
        return horario;
    }

    @Override
    public List<HorarioEntity> findAll() {
        List<HorarioEntity> horarios = repositorio.findAll();
        horarios.forEach(this::completar);
        return horarios;
    }

    @Override
    public List<HorarioEntity> findAllCustom() {
        List<HorarioEntity> horarios = repositorio.findAllCustom();
        horarios.forEach(this::completar);
        return horarios;
    }

    @Override
    public HorarioEntity findById(Long id) {
        return completar(repositorio.findById(id).get());
    }

    @Override
    public HorarioEntity add(HorarioEntity obj) {
        return repositorio.save(obj);
    }

    @Override
    public HorarioEntity update(HorarioEntity obj, Long id) {
        HorarioEntity objhor = repositorio.findById(id).get();
        BeanUtils.copyProperties(obj, objhor, "codigo");
        return repositorio.save(objhor);
    }
}