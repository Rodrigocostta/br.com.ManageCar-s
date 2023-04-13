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
import com.manageCars.manageCars.entities.Contato;
import com.manageCars.manageCars.entities.Lancamento;
import com.manageCars.manageCars.entities.OrdemServico;
import com.manageCars.manageCars.entities.Servico;
import com.manageCars.manageCars.entities.Veiculo;
import com.manageCars.manageCars.reposytories.ClienteRepository;
import com.manageCars.manageCars.reposytories.ContatoRepository;
import com.manageCars.manageCars.reposytories.LancamentoRepository;
import com.manageCars.manageCars.reposytories.OrdemServicoRepository;
import com.manageCars.manageCars.reposytories.ServicoRepository;
import com.manageCars.manageCars.reposytories.VeiculoRepository;

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
	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ContatoRepository contatoRepository;

	@Override
	public void run(String... args) throws Exception {

		// adicionando clientes em nossa entidade clientes
		Cliente c1 = new Cliente(null, "RODRIGO");
		Cliente c2 = new Cliente(null, "FRANCISCO");
		Cliente c3 = new Cliente(null, "ZÉ");
		Cliente c4 = new Cliente(null, "MANOEL");
		Cliente c5 = new Cliente(null, "JOÃO");

		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c4, c5));

		// CONTATOS CLIENTE
		Contato con1 = new Contato(null, 619854786, "rodrigo_@gmal.com", c1);
		Contato con2 = new Contato(null, 619845756, "francisco_@gmal.com", c2);
		Contato con3 = new Contato(null, 617863786, "ze_@gmal.com", c3);
		Contato con4 = new Contato(null, 619823886, "manoel_@gmal.com", c4);
		Contato con5 = new Contato(null, 619871986, "rodrigo_@gmal.com", c1);
		Contato con6 = new Contato(null, 619746886, "joao_@gmal.com", c5);

		contatoRepository.saveAll(Arrays.asList(con1, con2, con3, con4, con5, con6));

		c1.getContatos().add(con1);
		c2.getContatos().add(con2);
		c3.getContatos().add(con4);
		c5.getContatos().add(con5);
		c5.getContatos().add(con6);
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c4, c5));

		// CADSATRO VEICULO
		Veiculo v1 = new Veiculo(null, "vw", "Azerra", "hbf4578", c1);
		Veiculo v2 = new Veiculo(null, "Fiat", "palio", "hsf4578", c5);
		Veiculo v3 = new Veiculo(null, "vw", "nivus", "hbf4578", c1);
		Veiculo v4 = new Veiculo(null, "vw", "Polo", "hbf4578", c2);
		Veiculo v5 = new Veiculo(null, "vw", "s10", "hbf4578", c3);
		Veiculo v6 = new Veiculo(null, "vw", "tucson", "hbf4578", c4);

		veiculoRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6));

		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c4, c5));

		// servicos oferecido pela loja
		Servico servico = new Servico(null, "LAVAGEM AMERICANA", 35.00);
		Servico servico2 = new Servico(null, "lAVAGEM AMERICANA + APLICAÇÃO DE CERA LIQUIDA", 45.00);
		Servico servico3 = new Servico(null, "lAVAGEM AMERICANA + APLICAÇÃO DE CERA LIQUIDA", 50.00);
		Servico servico4 = new Servico(null, "CHASSI", 50.00);
		Servico servico5 = new Servico(null, "MOTOR", 50.00);
		Servico servico6 = new Servico(null, "HIGIENIZAÇÃO DE BANCO", 160.00);
		Servico servico7 = new Servico(null, "HIGIENIZAÇÃO DE CARPETE", 100.00);

		servicoRepository.saveAll(Arrays.asList(servico, servico2, servico3, servico4, servico5, servico6, servico7));

		// Save lançamento
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

		// RELACIONANDO CLIENTES E SERVICOS

		c1.getServicos().add(servico);
		c2.getServicos().add(servico5);
		c3.getServicos().add(servico4);
		c3.getServicos().add(servico2);
		c4.getServicos().add(servico5);
		c5.getServicos().add(servico3);
		c2.getServicos().add(servico7);

		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c4, c5));

		OrdemServico ordem = new OrdemServico(c1, v3, servico7, FormaPagamento.DEBITO, 100.00);
		OrdemServico ordem2 = new OrdemServico(c2, v4, servico6, FormaPagamento.DINEHIRO, 150.00);

		ordemServicoRepository.saveAll(Arrays.asList(ordem, ordem2));

	}

}