package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageCars.manageCars.entities.OrdemServico;
import com.manageCars.manageCars.reposytories.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	@Autowired
	private OrdemServicoRepository repository;

	public List<OrdemServico> findAll() {
		return repository.findAll();
	}

	public OrdemServico findBiId(Long id) {
		Optional<OrdemServico> obj = repository.findById(id);
		return obj.get();

	}

}
