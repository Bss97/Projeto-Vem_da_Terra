package com.vemdaterra.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vemdaterra.app.model.Categoria;
import com.vemdaterra.app.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoria;

	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos() {
		return ResponseEntity.ok(categoria.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
		return categoria.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>> buscarPorTipo(@Valid @PathVariable String tipo) {
		return ResponseEntity.ok(categoria.findAllByTipoContainingIgnoreCase(tipo));
	}

	@PostMapping
	public ResponseEntity<Categoria> cadastrarCategoria(@Valid @RequestBody Categoria categor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria.save(categor));
	}

	@PutMapping
	public ResponseEntity<Categoria> atualizarCategoria(@Valid @RequestBody Categoria categor) {
		return ResponseEntity.status(HttpStatus.OK).body(categoria.save(categor));
	}

	@DeleteMapping("/{id}")
	public void deletarCategoria(@Valid @PathVariable Long id) {
		categoria.deleteById(id);
	}

}
