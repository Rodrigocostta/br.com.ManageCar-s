package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.manageCars.manageCars.entities.Veiculo;
import com.manageCars.manageCars.reposytories.VeiculoRepository;

@org.springframework.stereotype.Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	public List<Veiculo> findAll() {
		return repository.findAll();
	}

	public Veiculo findById(long id) {

		Optional<Veiculo> obj = repository.findById(id);
		return obj.get();
	}

}
