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

	/* Buscando com parametro */
	public Contato findById(long id) {

		Optional<Contato> obj = repository.findById(id);
		return obj.get();
	}

	// INSERT
	public Contato insert(Contato obj) {
		return repository.save(obj);
	}

	// DELETE
	public void delete(Long id) {
		repository.deleteById(id);

	}

	public Contato update(Long id, Contato obj) {
		Contato entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(Contato entity, Contato obj) {
		entity.setCliente(obj.getCliente());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());

	}
}
