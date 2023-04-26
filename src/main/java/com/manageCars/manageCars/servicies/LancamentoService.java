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

	/* listar todos */

	public List<Lancamento> findAll() {
		return repository.findAll();
	}

	/* Buscando com parametro */
	public Lancamento findById(long id) {

		Optional<Lancamento> obj = repository.findById(id);
		return obj.get();
	}

	// INSERT
	public Lancamento insert(Lancamento obj) {
		return repository.save(obj);
	}

	// DELETE
	public void delete(Long id) {
		repository.deleteById(id);

	}

	public Lancamento update(Long id, Lancamento obj) {
		Lancamento entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(Lancamento entity, Lancamento obj) {
		entity.setCategoria(obj.getCategoria());
		entity.setData(obj.getData());
		entity.setFormaDePagamento(obj.getFormaDePagamento());
		entity.setLancamentoStatus(obj.getLancamentoStatus());
		entity.setDescricao(obj.getDescricao());
		entity.setValor(obj.getValor());

	}

}
