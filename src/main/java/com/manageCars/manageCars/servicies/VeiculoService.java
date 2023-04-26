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
	/* listar todos */

	public List<Veiculo> findAll() {
		return repository.findAll();
	}

	/* Buscando com parametro */
	public Veiculo findById(long id) {

		Optional<Veiculo> obj = repository.findById(id);
		return obj.get();
	}

	// INSERT
	public Veiculo insert(Veiculo obj) {
		return repository.save(obj);
	}

	// DELETE
	public void delete(Long id) {
		repository.deleteById(id);

	}

	public Veiculo update(Long id, Veiculo obj) {
		Veiculo entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(Veiculo entity, Veiculo obj) {
		entity.setMarca(obj.getMarca());
		entity.setModelo(obj.getModelo());
		entity.setPlaca(obj.getPlaca());
		entity.setCliente(obj.getCliente());
	}
}
