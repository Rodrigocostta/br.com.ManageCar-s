package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.manageCars.manageCars.entities.Usuario;
import com.manageCars.manageCars.reposytories.UsuarioRepository;

@org.springframework.stereotype.Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	/* listar todos */

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	/* Buscando com parametro */
	public Usuario findById(long id) {

		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}

	// INSERT
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}

	// DELETE
	public void delete(Long id) {
		repository.deleteById(id);

	}

	public Usuario update(Long id, Usuario obj) {
		Usuario entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(Usuario entity, Usuario obj) {
		entity.setUsuario(obj.getUsuario());
		entity.setSenha(obj.getSenha());

	}

}
