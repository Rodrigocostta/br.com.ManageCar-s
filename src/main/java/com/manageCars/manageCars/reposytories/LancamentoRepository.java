package com.manageCars.manageCars.reposytories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manageCars.manageCars.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
