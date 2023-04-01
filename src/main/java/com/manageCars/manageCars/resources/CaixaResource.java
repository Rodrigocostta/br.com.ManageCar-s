package com.manageCars.manageCars.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manageCars.manageCars.entities.Caixa;
import com.manageCars.manageCars.servicies.CaixaService;

@Controller
@RequestMapping(value = "/caixa")
public class CaixaResource {

	
	@Autowired
	private CaixaService service;

	@GetMapping
	ResponseEntity<List<Caixa>> findAll() {

		List<Caixa> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	ResponseEntity<Caixa> findById(@PathVariable Long id) {
		Caixa obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

}
