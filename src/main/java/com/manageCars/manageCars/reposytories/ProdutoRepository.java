package com.manageCars.manageCars.reposytories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manageCars.manageCars.entities.Produto;

	
	public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		

	}


