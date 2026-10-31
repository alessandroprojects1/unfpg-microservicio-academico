package pe.com.unfpg.academico.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "DetalleMatriculaEntity")
@Table(name = "detallematricula", uniqueConstraints = @UniqueConstraint(columnNames = { "nummat", "codsec" }))
public class DetalleMatriculaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "coddet")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "estdet", nullable = false)
	private Boolean estado;

	// claves foraneas
	@ManyToOne
	@JoinColumn(name = "nummat", nullable = false)
	private MatriculaEntity matricula;

	@ManyToOne
	@JoinColumn(name = "codsec", nullable = false)
	private SeccionEntity seccion;
}