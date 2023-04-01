package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.manageCars.manageCars.entities.Caixa;
import com.manageCars.manageCars.reposytories.CaixaRepository;

@org.springframework.stereotype.Service
public class CaixaService {
	
	
	/*listar todos*/
	@Autowired
	private CaixaRepository repository;
	
	public List<Caixa> findAll(){
		return repository.findAll();
	}
	
	
	/* Buscando com parametro */
	public Caixa findById(long id) {

		Optional<Caixa> obj = repository.findById(id);
		return obj.get();
	}

}
