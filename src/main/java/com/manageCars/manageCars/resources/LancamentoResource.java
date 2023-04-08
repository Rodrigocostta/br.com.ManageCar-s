package com.manageCars.manageCars.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manageCars.manageCars.entities.Lancamento;
import com.manageCars.manageCars.servicies.LancamentoService;

@RestController
@RequestMapping(value = "/lancamento")
public class LancamentoResource {

	@Autowired
	private LancamentoService service;

	@GetMapping
	ResponseEntity<List<Lancamento>> findAll() {
		List<Lancamento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	ResponseEntity<Lancamento> findBiId(@PathVariable Long id) {

		Lancamento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}
}
