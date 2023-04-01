package com.manageCars.manageCars.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manageCars.manageCars.entities.Servico;
import com.manageCars.manageCars.servicies.ServicoService;

@Controller
@RequestMapping(value = "/servico")
public class ServicoResource {

	@Autowired
	private ServicoService service;

	@GetMapping
	ResponseEntity<List<Servico>> findAll() {

		List<Servico> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	ResponseEntity<Servico> findById(@PathVariable Long id) {
		Servico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

}
