package br.com.fiap.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.repository.AtletaRepository;
import br.com.fiap.repository.TreinadorRepository;
import br.com.fiap.repository.TreinoRepository;
import br.com.fiap.model.Atleta;
import br.com.fiap.model.Treinador;
import br.com.fiap.model.Treino;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    AtletaRepository repoAtleta;

    @Autowired
    TreinadorRepository repoTreinador;

    @Autowired
    TreinoRepository repoTreino;

    @Override
    public void run(String... args) throws Exception {
        Atleta atleta1 = new Atleta("Gabriel", LocalDate.now());
        Atleta atleta2 = new Atleta("Pedro", LocalDate.now());
        Atleta atleta3 = new Atleta("João", LocalDate.now());

        Treinador treinador1 = new Treinador("Lucas", LocalDate.now());
        Treinador treinador2 = new Treinador("Samuel", LocalDate.now());
        Treinador treinador3 = new Treinador("Henrique", LocalDate.now());

        repoAtleta.saveAll(List.of(atleta1, atleta2, atleta3));
        repoTreinador.saveAll(List.of(treinador1, treinador2, treinador3));
        repoTreino.saveAll(List.of(
            new Treino(LocalDateTime.now(), treinador1, atleta1),
            new Treino(LocalDateTime.now(), treinador2, atleta2),
            new Treino(LocalDateTime.now(), treinador3, atleta3)
        ));
    }
}
