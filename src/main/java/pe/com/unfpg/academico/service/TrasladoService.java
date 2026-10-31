package pe.com.unfpg.academico.service;

import java.util.List;

import pe.com.unfpg.academico.entity.TrasladoEntity;

public interface TrasladoService {

	List<TrasladoEntity> findAll();

	List<TrasladoEntity> findAllCustom();

	TrasladoEntity findById(Long id);

	TrasladoEntity add(TrasladoEntity obj);

	TrasladoEntity update(TrasladoEntity obj, Long id);

	TrasladoEntity delete(Long id);

	TrasladoEntity enable(Long id);
}
