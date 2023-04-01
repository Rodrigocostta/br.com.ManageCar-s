package com.manageCars.manageCars.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manageCars.manageCars.entities.Veiculo;
import com.manageCars.manageCars.servicies.VeiculoService;

@Controller
@RequestMapping(value = "/veiculo")
public class VeiculoResource {

	@Autowired
	private VeiculoService service;

	@GetMapping
	ResponseEntity<List<Veiculo>> findAll() {

		List<Veiculo> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	ResponseEntity<Veiculo> findById(@PathVariable Long id) {
		Veiculo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}
}
