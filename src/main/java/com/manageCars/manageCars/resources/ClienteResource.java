package com.manageCars.manageCars.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manageCars.manageCars.entities.Cliente;
import com.manageCars.manageCars.servicies.ClienteService;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	ResponseEntity<List<Cliente>> findAll() {

		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

}