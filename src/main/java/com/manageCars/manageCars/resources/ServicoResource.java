package com.manageCars.manageCars.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	// INSERINDO UM NOVO USUARIO
	@PostMapping
	public ResponseEntity<Servico> insert(@RequestBody Servico obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("${id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	// DELETE POR ID

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Servico> update(@PathVariable Long id, @RequestBody Servico obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
