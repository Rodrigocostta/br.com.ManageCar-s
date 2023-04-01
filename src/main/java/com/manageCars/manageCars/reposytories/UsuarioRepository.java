package com.manageCars.manageCars.reposytories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manageCars.manageCars.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
