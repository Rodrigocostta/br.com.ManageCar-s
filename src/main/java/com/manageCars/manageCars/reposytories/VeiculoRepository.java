package com.manageCars.manageCars.reposytories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manageCars.manageCars.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

}
