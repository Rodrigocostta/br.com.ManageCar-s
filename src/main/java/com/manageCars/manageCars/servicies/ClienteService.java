package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.manageCars.manageCars.entities.Cliente;
import com.manageCars.manageCars.reposytories.ClienteRepository;

@org.springframework.stereotype.Service
public class ClienteService {
	
	
	/*listar todos*/
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	
	/* Buscando com parametro */
	public Cliente findById(long id) {

		Optional<Cliente> obj = repository.findById(id);
		return obj.get();
	}
}
