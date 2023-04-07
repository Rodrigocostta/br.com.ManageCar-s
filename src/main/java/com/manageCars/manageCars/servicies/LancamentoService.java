package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageCars.manageCars.entities.Lancamento;
import com.manageCars.manageCars.reposytories.LancamentoRepository;

@Service
public class LancamentoService {

	/* listar todos */
	@Autowired
	private LancamentoRepository repository;

	public List<Lancamento> findAll() {
		return repository.findAll();
	}

	/* Buscando com parametro */
	public Lancamento findById(long id) {

		Optional<Lancamento> obj = repository.findById(id);
		return obj.get();
	}

}
