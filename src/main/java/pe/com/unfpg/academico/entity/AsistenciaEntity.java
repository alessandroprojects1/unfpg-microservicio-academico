package pe.com.unfpg.academico.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "AsistenciaEntity")
@Table(name = "asistencia")
public class AsistenciaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codasis")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "fecasis", nullable = false)
	private LocalDateTime fecha;

	@Column(name = "presente", nullable = false)
	private Boolean presente;

	@Column(name = "justificada", nullable = false)
	private Boolean justificada;

	// claves foraneas
	@ManyToOne
	@JoinColumn(name = "coddet", nullable = false)
	private DetalleMatriculaEntity detallematricula;

	@ManyToOne
	@JoinColumn(name = "codsec", nullable = false)
	private SeccionEntity seccion;
}