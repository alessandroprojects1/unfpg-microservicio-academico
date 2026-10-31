package pe.com.unfpg.academico.entity;
import java.io.Serializable;
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
@Entity(name = "FacultadEntity")
@Table(name = "facultad")
public class FacultadEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codfac")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "nomfac",length = 30, nullable = false)
	private String nombre;
	@Column (name ="desfac", length = 300, nullable = false)
	private String descripcion;
	@Column(name = "estfac", nullable = false)
	private Boolean estado;
}