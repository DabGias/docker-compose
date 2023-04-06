package br.com.fiap.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_treino")
public class Treino {
    @Id
    @GeneratedValue(
            generator = "seq_treino",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "seq_treino",
            sequenceName = "seq_treino",
            allocationSize = 1
    )
    @Column(name = "id_treino")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_hr_treino")
    private LocalDateTime inicioTreino;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "id_treinador",
            referencedColumnName = "id_treinador",
            foreignKey = @ForeignKey(
                    name = "fk_tb_treinador",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Treinador treinador;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "id_atleta",
            referencedColumnName = "id_atleta",
            foreignKey = @ForeignKey(
                    name = "fk_tb_atleta",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Atleta atleta;

    public Treino() {}

    public Treino(Long id, LocalDateTime inicioTreino, Treinador treinador, Atleta atleta) {
        this.id = id;
        this.inicioTreino = inicioTreino;
        this.treinador = treinador;
        this.atleta = atleta;
    }

    public Treino(LocalDateTime inicioTreino, Treinador treinador, Atleta atleta) {
        this.inicioTreino = inicioTreino;
        this.treinador = treinador;
        this.atleta = atleta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInicioTreino() {
        return inicioTreino;
    }

    public void setInicioTreino(LocalDateTime inicioTreino) {
        this.inicioTreino = inicioTreino;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Treino {");
        sb.append(" id = ").append(id);
        sb.append(", inicioTreino = ").append(inicioTreino);
        sb.append(", treinador = ").append(treinador);
        sb.append(", atleta = ").append(atleta);
        sb.append('}');

        return sb.toString();
    }
}
