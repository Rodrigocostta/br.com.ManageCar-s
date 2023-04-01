package com.manageCars.manageCars.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manageCars.manageCars.entities.Produto;
import com.manageCars.manageCars.servicies.ProdutoService;

@Controller
@RequestMapping(value = "/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@GetMapping
	ResponseEntity<List<Produto>> findAll() {

		List<Produto> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

}
