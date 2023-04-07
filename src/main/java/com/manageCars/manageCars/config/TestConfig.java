package com.manageCars.manageCars.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.manageCars.manageCars.Enus.LancamentoStatus;
import com.manageCars.manageCars.entities.Lancamento;
import com.manageCars.manageCars.entities.Produto;
import com.manageCars.manageCars.reposytories.LancamentoRepository;
import com.manageCars.manageCars.reposytories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private LancamentoRepository lancamentoRepository;


	
	 
	@Override
	public void run(String... args) throws Exception {
  
		
		
		    /*Save produto*/
		Produto ul = new Produto(null,"teste",10.00);
		
		produtoRepository.saveAll(Arrays.asList(ul));
		

		/*Save lançamento*/
		 Lancamento lancamento = new Lancamento(null, "higienização de banco", "servico", null, 250.00, LancamentoStatus.GANHO);
		 Lancamento lancamento2 = new Lancamento(null, "Lm", "produto", null, 70.00, LancamentoStatus.DESPESA);
		 Lancamento lancamento3 = new Lancamento(null, "Internet", "intrenimento", null, 120.00, LancamentoStatus.INVESTIMENTO);
		 Lancamento lancamento4 = new Lancamento(null, "lavagem americana", "servico", null, 35.00, LancamentoStatus.GANHO);
		 Lancamento lancamento5 = new Lancamento(null, "Solupã", "produto", null, 70.00, LancamentoStatus.DESPESA);



	lancamentoRepository.saveAll(Arrays.asList(lancamento,lancamento2,lancamento3,lancamento4,lancamento5));
	}

	
	

}                              