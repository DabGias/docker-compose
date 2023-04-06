package br.com.fiap.controller;

import br.com.fiap.model.Treino;
import br.com.fiap.repository.TreinoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/treino")
public class TreinoController {

    @Autowired
    TreinoRepository repo;

    @GetMapping
    public List<Treino> index() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Treino> show(@PathVariable Long id) {
        Treino treino = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Treino não encontrado")
        );

        return ResponseEntity.ok(treino);
    }

    @PostMapping
    public ResponseEntity<Treino> create(@RequestBody Treino treino, BindingResult result) {
        repo.save(treino);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Treino> update(@PathVariable Long id, @RequestBody Treino treinoAtualizado) {
        Treino treino = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atleta não encontrado")
        );

        BeanUtils.copyProperties(treinoAtualizado, treino, "id");

        repo.save(treino);

        return ResponseEntity.ok(treino);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Treino> destroy(@PathVariable Long id) {
        Treino treino = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Treino não encontrado")
        );

        repo.delete(treino);

        return ResponseEntity.noContent().build();
    }
}
