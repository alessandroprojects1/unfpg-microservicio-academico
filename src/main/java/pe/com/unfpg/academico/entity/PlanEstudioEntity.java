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
@Entity(name = "PlanEstudioEntity")
@Table(name = "planestudio")
public class PlanEstudioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codpla")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nompla", length = 100, nullable = false)
    private String nombre;

    @Column(name = "despla")
    private String descripcion;

    @Column(name = "estpla", nullable = false)
    private Boolean estado;

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

    @ManyToOne
    @JoinColumn(name = "codprog", nullable = false)
    private ProgramaEntity programa;
}