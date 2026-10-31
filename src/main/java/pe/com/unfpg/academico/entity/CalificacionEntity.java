package pe.com.unfpg.academico.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "CalificacionEntity")
@Table(name = "calificacion")
public class CalificacionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codcal")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "feccal", nullable = false)
	private LocalDateTime fecha;

	@Column(name = "nota", precision = 5, scale = 2, nullable = false)
	private BigDecimal nota;

	// Relaciones dentro de Académico
	@ManyToOne
	@JoinColumn(name = "coddet", nullable = false)
	private DetalleMatriculaEntity detallematricula;

	@ManyToOne
	@JoinColumn(name = "codsec", nullable = false)
	private SeccionEntity seccion;

	// Clave foránea a Catálogo (por Feign)
	@Column(name = "codtipc", nullable = false)
	private Long codtipc;

	@Transient
	private Object tipocalificacion;
}