package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.manageCars.manageCars.entities.Usuario;
import com.manageCars.manageCars.reposytories.UsuarioRepository;

@org.springframework.stereotype.Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	/* Listar todos */
	public List<Usuario> findAll() {
		return repository.findAll();

	}

	/* Listra por id */
	public Usuario findById(long id) {

		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}

}
