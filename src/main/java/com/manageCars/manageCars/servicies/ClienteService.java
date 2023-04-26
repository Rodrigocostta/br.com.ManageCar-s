package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageCars.manageCars.entities.Cliente;
import com.manageCars.manageCars.reposytories.ClienteRepository;

@Service
public class ClienteService {
	
	

	@Autowired
	private ClienteRepository repository;
	
	/*listar todos*/
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	
	/* Buscando com parametro */
	public Cliente findById(long id) {

		Optional<Cliente> obj = repository.findById(id);
		return obj.get();
	}

	// INSERT
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}

	//DELETE
	public void delete(Long id) {
		repository.deleteById(id);
		
	}
	
	public Cliente update(Long id, Cliente obj) {
		Cliente entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
	
	}
}
