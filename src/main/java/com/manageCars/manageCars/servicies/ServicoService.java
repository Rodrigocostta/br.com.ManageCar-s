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
/*listar todos*/
	
	public List<Servico> findAll(){
		return repository.findAll();
	}
	
	
	/* Buscando com parametro */
	public Servico findById(long id) {

		Optional<Servico> obj = repository.findById(id);
		return obj.get();
	}

	// INSERT
	public Servico insert(Servico obj) {
		return repository.save(obj);
	}

	//DELETE
	public void delete(Long id) {
		repository.deleteById(id);
		
	}
	
	public Servico update(Long id, Servico obj) {
		Servico entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(Servico entity, Servico obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setValor(obj.getValor());
	
	}

}
