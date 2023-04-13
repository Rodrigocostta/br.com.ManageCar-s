package com.manageCars.manageCars.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manageCars.manageCars.entities.OrdemServico;
import com.manageCars.manageCars.servicies.OrdemServicoService;

@RestController
@RequestMapping(value = "/ordemServico")
public class OrdemServicoResource {
	@Autowired
	private OrdemServicoService servico;

	@GetMapping
	ResponseEntity<List<OrdemServico>> findAll() {
		List<OrdemServico> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	ResponseEntity<OrdemServico> findById(@PathVariable Long id) {
		OrdemServico obj = servico.findBiId(id);
		return ResponseEntity.ok().body(obj);
	}

}
