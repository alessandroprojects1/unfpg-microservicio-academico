package pe.com.unfpg.academico.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "PeriodoAcademicoEntity")
@Table(name = "periodoacademico")
public class PeriodoAcademicoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codper")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomper", length = 20, nullable = false, unique = true)
	private String nombre;
	@Column(name = "fecini")
	private LocalDate fechaInicio;
	@Column(name = "fecfin")
	private LocalDate fechaFin;
	@Column(name = "desper", columnDefinition = "TEXT")
	private String descripcion;
	@Column(name = "estper", nullable = false)
	private Boolean estado;
}