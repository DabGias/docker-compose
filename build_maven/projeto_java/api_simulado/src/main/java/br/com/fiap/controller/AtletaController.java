package br.com.fiap.controller;

import br.com.fiap.model.Atleta;
import br.com.fiap.repository.AtletaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/atleta")
public class AtletaController {

    @Autowired
    AtletaRepository repo;

    @GetMapping
    public List<Atleta> index() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Atleta> show(@PathVariable Long id) {
        Atleta atleta = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atleta não encontrado")
        );

        return ResponseEntity.ok(atleta);
    }

    @PostMapping
    public ResponseEntity<Atleta> create(@RequestBody Atleta atleta, BindingResult result) {
        repo.save(atleta);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Atleta> update(@PathVariable Long id, @RequestBody Atleta atletaAtualizado) {
        Atleta atleta = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atleta não encontrado")
        );

        BeanUtils.copyProperties(atletaAtualizado, atleta, "id");

        repo.save(atleta);

        return ResponseEntity.ok(atleta);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Atleta> destroy(@PathVariable Long id) {
        Atleta atleta = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atleta não encontrado")
        );

        repo.delete(atleta);

        return ResponseEntity.noContent().build();
    }
}
