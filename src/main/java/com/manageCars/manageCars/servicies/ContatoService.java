package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageCars.manageCars.entities.Contato;
import com.manageCars.manageCars.reposytories.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;

	/* listar todos */
	public List<Contato> findAll() {

		return repository.findAll();
	}

	/* Listar especifico por id */
	public Contato findById(long id) {

		Optional<Contato> obj = repository.findById(id);
		return obj.get();
	}
}
