package com.manageCars.manageCars.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.manageCars.manageCars.entities.Produto;
import com.manageCars.manageCars.reposytories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoReposytori;

	@Override
	public void run(String... args) throws Exception {

		Produto ul = new Produto(null,"teste",10.00);
		
		produtoReposytori.saveAll(Arrays.asList(ul));
	}

}