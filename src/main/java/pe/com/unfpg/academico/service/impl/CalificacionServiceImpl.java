package pe.com.unfpg.academico.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.academico.client.CatalogoFeignClient;
import pe.com.unfpg.academico.entity.CalificacionEntity;
import pe.com.unfpg.academico.repository.CalificacionRepository;
import pe.com.unfpg.academico.service.CalificacionService;

@Service
public class CalificacionServiceImpl implements CalificacionService {

	private final CalificacionRepository repositorio;
	private final CatalogoFeignClient catalogoFeignClient;

	public CalificacionServiceImpl(CalificacionRepository repositorio,
			CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
	}

	private void validarNota(BigDecimal nota) {
		if (nota == null || nota.compareTo(BigDecimal.ZERO) < 0 || nota.compareTo(new BigDecimal("20")) > 0) {
			throw new IllegalArgumentException("La nota debe estar entre 0 y 20");
		}
	}

	private CalificacionEntity completar(CalificacionEntity calificacion) {
		calificacion.setTipocalificacion(
				catalogoFeignClient.getTipoCalificacion(calificacion.getCodtipc()));
		return calificacion;
	}

	@Override
	public List<CalificacionEntity> findAll() {
		List<CalificacionEntity> calificaciones = repositorio.findAll();
		calificaciones.forEach(this::completar);
		return calificaciones;
	}

	@Override
	public CalificacionEntity findById(Long id) {
		return completar(repositorio.findById(id).get());
	}

	@Override
	public CalificacionEntity add(CalificacionEntity obj) {
		validarNota(obj.getNota());
		if (obj.getFecha() == null) {
			obj.setFecha(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}

	@Override
	public CalificacionEntity update(CalificacionEntity obj, Long id) {
		validarNota(obj.getNota());
		CalificacionEntity objcal = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objcal, "codigo");
		return repositorio.save(objcal);
	}

	@Override
	public CalificacionEntity delete(Long id) {
		CalificacionEntity objcal = repositorio.findById(id).get();
		repositorio.deleteById(id);
		return objcal;
	}
}