package com.manageCars.manageCars.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manageCars.manageCars.entities.Contato;
import com.manageCars.manageCars.servicies.ContatoService;

@Controller
@RequestMapping(value = "/contato")
public class ContatoResource {

	@Autowired
	private ContatoService service;

	@GetMapping
	ResponseEntity<List<Contato>> findAll() {

		List<Contato> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	ResponseEntity<Contato> findById(@PathVariable Long id) {
		Contato obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}
}
