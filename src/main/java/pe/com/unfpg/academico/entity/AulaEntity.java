package pe.com.unfpg.academico.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Transient;
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
@Entity(name = "AulaEntity")
@Table(name = "aula")
public class AulaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codaul")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomaul", length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(name = "capaul", nullable = false)
    private Integer capacidad;
    

    // Claves foráneas
    
    @Column(name = "codubi", nullable = false)
    private Long codubi;

    
    @Column(name = "codtipa", nullable = false)
    private Long codtipa;

  
    @Column(name = "codesta", nullable = false)
    private Long codesta;
    
    
  //campos temporales
  	@Transient
  	private Object tipoaula;
  	@Transient
  	private Object ubicacion;
  	@Transient
  	private Object estadoaula;
  	
}