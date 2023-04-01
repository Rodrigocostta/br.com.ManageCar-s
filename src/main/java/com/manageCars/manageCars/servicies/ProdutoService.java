 package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.manageCars.manageCars.entities.Produto;
import com.manageCars.manageCars.reposytories.ProdutoRepository;

@org.springframework.stereotype.Service
public class ProdutoService {

	/* Listando todos */
	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();

	}
	
	/* Buscando com parametro */
	public Produto findById(long id) {

		Optional<Produto> obj = repository.findById(id);
		return obj.get();
	}
}
