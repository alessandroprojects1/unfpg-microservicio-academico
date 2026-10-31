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
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "HorarioEntity")
@Table(name = "horario")
public class HorarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codhor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    // Relaciones dentro de Académico
    @ManyToOne
    @JoinColumn(name = "codsec", nullable = false)
    private SeccionEntity seccion;

    @ManyToOne
    @JoinColumn(name = "codaul", nullable = false)
    private AulaEntity aula;

    // Claves foráneas a Catálogo (por Feign)
    @Column(name = "codblo", nullable = false)
    private Long codblo;

    @Column(name = "coddias", nullable = false)
    private Long coddias;

    @Transient
    private Object bloque;

    @Transient
    private Object diasemana;
}