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
@Entity(name = "ProgramaEntity")
@Table(name = "programa")
public class ProgramaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codprog")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomprog", length = 100, nullable = false)
    private String nombre;

    @Column(name = "estprog", nullable = false)
    private Boolean estado;

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

    @ManyToOne
    @JoinColumn(name = "codfac", nullable = false)
    private FacultadEntity facultad;
}