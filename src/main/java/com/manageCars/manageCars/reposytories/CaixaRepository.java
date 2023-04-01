package com.manageCars.manageCars.reposytories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manageCars.manageCars.entities.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Long> {
	

}

