package com.manageCars.manageCars.reposytories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manageCars.manageCars.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
