package br.com.fiap.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_atleta")
public class Atleta {
    @Id
    @GeneratedValue(
            generator = "seq_atleta",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "seq_atleta",
            sequenceName = "seq_atleta",
            allocationSize = 1
    )
    @Column(name = "id_atleta")
    private Long id;

    @Column(name = "nome_atleta")
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento_atleta")
    private LocalDate dataNascimento;

    public Atleta() {}

    public Atleta(Long id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Atleta(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AtletaModel {");
        sb.append(" id = ").append(id);
        sb.append(", nome = '").append(nome).append('\'');
        sb.append(", dataNascimento = ").append(dataNascimento);
        sb.append('}');

        return sb.toString();
    }
}
