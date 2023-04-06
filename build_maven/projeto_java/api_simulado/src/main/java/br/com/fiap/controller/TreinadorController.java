package br.com.fiap.controller;

import br.com.fiap.model.Treinador;
import br.com.fiap.repository.TreinadorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/treinador")
public class TreinadorController {

    @Autowired
    TreinadorRepository repo;

    @GetMapping
    public List<Treinador> index() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Treinador> show(@PathVariable Long id) {
        Treinador treinador = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Treinador não encontrado")
        );

        return ResponseEntity.ok(treinador);
    }

    @PostMapping
    public ResponseEntity<Treinador> create(@RequestBody Treinador treinador, BindingResult result) {
        repo.save(treinador);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Treinador> update(@PathVariable Long id, @RequestBody Treinador treinadorAtualizado) {
        Treinador treinador = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Treinador não encontrado")
        );

        BeanUtils.copyProperties(treinadorAtualizado, treinador, "id");

        repo.save(treinador);

        return ResponseEntity.ok(treinador);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Treinador> destroy(@PathVariable Long id) {
        Treinador treinador = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Treinador não encontrado")
        );

        repo.delete(treinador);

        return ResponseEntity.noContent().build();
    }
}
