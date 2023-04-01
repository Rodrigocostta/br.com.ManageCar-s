package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.manageCars.manageCars.entities.Servico;
import com.manageCars.manageCars.reposytories.ServicoRepository;

@org.springframework.stereotype.Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository;

	public List<Servico> findAll() {
		return repository.findAll();
	}

	public Servico findById(long id) {

		Optional<Servico> obj = repository.findById(id);
		return obj.get();

	}
}
