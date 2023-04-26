package com.manageCars.manageCars.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.manageCars.manageCars.entities.OrdemServico;
import com.manageCars.manageCars.servicies.OrdemServicoService;

@RestController
@RequestMapping(value = "/ordemServico")
public class OrdemServicoResource {
	@Autowired
	private OrdemServicoService service;

	@GetMapping
	ResponseEntity<List<OrdemServico>> findAll() {

		List<OrdemServico> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	ResponseEntity<OrdemServico> findById(@PathVariable Long id) {
		OrdemServico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	// INSERINDO UM NOVO USUARIO
	@PostMapping
	public ResponseEntity<OrdemServico> insert(@RequestBody OrdemServico obj) {
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
	public ResponseEntity<OrdemServico> update(@PathVariable Long id, @RequestBody OrdemServico obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
