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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "TrasladoEntity")
@Table(name = "traslado")
public class TrasladoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codtra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "progori", length = 100)
	private String programaorigen;

	@Column(name = "uniori", length = 100)
	private String universidadorigen;

	@Column(name = "esttras", nullable = false)
	private Boolean estado;

	// claves foraneas
	@ManyToOne
	@JoinColumn(name = "nummat", nullable = false)
	private MatriculaEntity matricula;
}