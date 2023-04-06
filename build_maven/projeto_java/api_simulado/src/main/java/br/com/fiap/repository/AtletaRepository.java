package br.com.fiap.repository;

import br.com.fiap.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {}
