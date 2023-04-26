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

	/* listar todos */

	public List<OrdemServico> findAll() {
		return repository.findAll();
	}

	/* Buscando com parametro */
	public OrdemServico findById(long id) {

		Optional<OrdemServico> obj = repository.findById(id);
		return obj.get();
	}

	// INSERT
	public OrdemServico insert(OrdemServico obj) {
		return repository.save(obj);
	}

	// DELETE
	public void delete(Long id) {
		repository.deleteById(id);

	}

	public OrdemServico update(Long id, OrdemServico obj) {
		OrdemServico entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(OrdemServico entity, OrdemServico obj) {
		entity.setFormaDePagamento(obj.getFormaDePagamento());
		entity.setValorTotal(obj.getValorTotal());
		entity.setCliente(obj.getCliente());
		entity.setVeiculo(obj.getVeiculo());
		entity.setServico(obj.getServico());

	}

}
