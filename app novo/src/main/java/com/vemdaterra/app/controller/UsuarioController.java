package com.vemdaterra.app.controller;

import java.util.List;
import java.util.Optional;

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

import com.vemdaterra.app.model.Usuario;
import com.vemdaterra.app.model.dto.UserLogin;
import com.vemdaterra.app.repository.UsuarioRepository;
import com.vemdaterra.app.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuario;

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodos() {
		return ResponseEntity.ok(usuario.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
		return usuario.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody Usuario usuario1) {
		return service.CadastrarUsuario(usuario1)
				.map(usuarioCadastrado -> ResponseEntity.status(201).body(usuarioCadastrado))
				.orElse(ResponseEntity.status(400).build());
	}

	@PostMapping("/login")
	public ResponseEntity<UserLogin> logarNaConta(@Valid @RequestBody Optional<UserLogin> user) {
		return service.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizarUsuario(@Valid @RequestBody Usuario usuario1) {
		return ResponseEntity.status(HttpStatus.OK).body(usuario.save(usuario1));
	}

	@DeleteMapping("/{id}")
	public void deletarUsuario(@Valid @PathVariable Long id) {
		usuario.deleteById(id);
	}

}
