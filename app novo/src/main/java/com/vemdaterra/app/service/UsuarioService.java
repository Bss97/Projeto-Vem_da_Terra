package com.vemdaterra.app.service;

import java.nio.charset.Charset;

import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vemdaterra.app.model.Usuario;
import com.vemdaterra.app.model.dto.UserLogin;
import com.vemdaterra.app.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Optional<Usuario> CadastrarUsuario(Usuario usuario) {
		Optional<Usuario> usuarioExistente = repository.findAllByEmailContainingIgnoreCase(usuario.getEmail());
	
		if (usuarioExistente.isPresent()) {
			return Optional.empty();
		} else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			String senhaEncoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEncoder);

			return Optional.ofNullable(repository.save(usuario));

		}

	}

	public Optional<UserLogin> Logar(Optional<UserLogin> userEmail) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findAllByEmailContainingIgnoreCase(userEmail.get().getEmail());

		if (usuario.isPresent()) {
			if (encoder.matches(userEmail.get().getSenha(), usuario.get().getSenha())) {

				String auth = userEmail.get().getEmail() + ":" + userEmail.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);

				userEmail.get().setToken(authHeader);
				userEmail.get().setNome(usuario.get().getNome());

				return userEmail;
			}
		}
		return null;
	}

}
