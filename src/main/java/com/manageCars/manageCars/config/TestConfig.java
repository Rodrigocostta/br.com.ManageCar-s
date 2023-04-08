package com.manageCars.manageCars.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.manageCars.manageCars.Enuns.FormaPagamento;
import com.manageCars.manageCars.Enuns.LancamentoStatus;
import com.manageCars.manageCars.entities.Cliente;
import com.manageCars.manageCars.entities.Lancamento;
import com.manageCars.manageCars.entities.Servico;
import com.manageCars.manageCars.reposytories.ClienteRepository;
import com.manageCars.manageCars.reposytories.LancamentoRepository;
import com.manageCars.manageCars.reposytories.ServicoRepository;

@Configuration
@EnableJpaAuditing
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ServicoRepository servicoRepository;

	@Override
	public void run(String... args) throws Exception {

		/* adicionando clientes em nossa entidade clientes */
		Cliente cliente = new Cliente(null, "RODRIGO");
		Cliente cliente2 = new Cliente(null, "FRANCISCO");
		Cliente cliente3 = new Cliente(null, "ZÉ");
		Cliente cliente4 = new Cliente(null, "MANOEL");
		Cliente cliente5 = new Cliente(null, "JOÃO");
		Cliente cliente6 = new Cliente(null, "KAIO");
		Cliente cliente7 = new Cliente(null, "NICOLAS");
		Cliente cliente8 = new Cliente(null, "MARIA");
		Cliente cliente9 = new Cliente(null, "MEIRE");
		Cliente cliente10 = new Cliente(null, "LÉO");

		clienteRepository.saveAll(Arrays.asList(cliente, cliente2, cliente3, cliente4, cliente4, cliente5, cliente6,
				cliente7, cliente8, cliente9, cliente10));

		/* servicos oferecido pela loja */
		Servico servico = new Servico(null, "LAVAGEM AMERICANA", 35.00);
		Servico servico2 = new Servico(null, "lAVAGEM AMERICANA + APLICAÇÃO DE CERA LIQUIDA", 45.00);
		Servico servico3 = new Servico(null, "lAVAGEM AMERICANA + APLICAÇÃO DE CERA LIQUIDA", 50.00);
		Servico servico4 = new Servico(null, "CHASSI", 50.00);
		Servico servico5 = new Servico(null, "MOTOR", 50.00);
		Servico servico6 = new Servico(null, "HIGIENIZAÇÃO DE BANCO", 160.00);
		Servico servico7 = new Servico(null, "HIGIENIZAÇÃO DE CARPETE", 100.00);

		servicoRepository.saveAll(Arrays.asList(servico, servico2, servico3, servico4, servico5, servico6, servico7));

		/* Save lançamento */
		Lancamento lancamento = new Lancamento(null, "higienização de banco", "servico", null, 250.00,
				LancamentoStatus.GANHO, FormaPagamento.CREDITO);
		Lancamento lancamento2 = new Lancamento(null, "Lm", "produto", null, 70.00, LancamentoStatus.DESPESA,
				FormaPagamento.CREDITO);
		Lancamento lancamento3 = new Lancamento(null, "Internet", "intrenimento", null, 120.00,
				LancamentoStatus.INVESTIMENTO, FormaPagamento.PIX);
		Lancamento lancamento4 = new Lancamento(null, "lavagem americana", "servico", null, 35.00,
				LancamentoStatus.GANHO, FormaPagamento.DEBITO);
		Lancamento lancamento5 = new Lancamento(null, "Solupã", "produto", null, 70.00, LancamentoStatus.DESPESA,
				FormaPagamento.PIX);

		lancamentoRepository.saveAll(Arrays.asList(lancamento, lancamento2, lancamento3, lancamento4, lancamento5));

		/* RELACIONANDO CLIENTES E SERVICOS */

		cliente.getServicos().add(servico);
		cliente2.getServicos().add(servico5);
		cliente3.getServicos().add(servico4);
		cliente3.getServicos().add(servico2);
		cliente4.getServicos().add(servico5);
		cliente5.getServicos().add(servico3);
		cliente2.getServicos().add(servico7);
		cliente6.getServicos().add(servico6);
		cliente7.getServicos().add(servico2);
		cliente8.getServicos().add(servico4);
		cliente9.getServicos().add(servico);
		cliente10.getServicos().add(servico4);
		clienteRepository.saveAll(Arrays.asList(cliente, cliente2, cliente3, cliente4, cliente4, cliente5, cliente6,
				cliente7, cliente8, cliente9, cliente10));
	}

}