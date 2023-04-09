package com.manageCars.manageCars.entities;

import java.io.Serializable;

import com.manageCars.manageCars.Enuns.FormaPagamento;
import com.manageCars.manageCars.entities.pk.OrdemServicoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdemServicoPK id;
	private Integer formaDePagamento;
	private Double valorTotal;

	/* Constructros */

	public OrdemServico(Cliente cliente, Veiculo veiculo, Servico servico, FormaPagamento formaDePagamento,
			Double valorTotal) {
		super();
		setFormaDePagamento(formaDePagamento);
		this.valorTotal = valorTotal;
		id.setCliente(cliente);
		id.setVeiculo(veiculo);
		id.setServico(servico);
	}
	/* getters and setters */

	public Cliente getCliente() {
		return id.getCliente();
	}

	public void setCliente(Veiculo veiculo) {
		id.setVeiculo(veiculo);
	}

	public Servico getServico() {
		return id.getServico();
	}

	public void setServico(Servico servico) {
		id.setServico(servico);
	}

	public Veiculo getVeiculo() {
		return id.getVeiculo();
	}

	public void setVeiculo(Cliente cliente) {
		id.setCliente(cliente);
	}

	public FormaPagamento getFormaDePagamento() {
		return FormaPagamento.valueOf(formaDePagamento);
	}

	public void setFormaDePagamento(FormaPagamento formaDePagamento) {
		if (formaDePagamento != null) {
			this.formaDePagamento = formaDePagamento.getCode2();
		}
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public OrdemServicoPK getId() {
		return id;
	}

	public void setId(OrdemServicoPK id) {
		this.id = id;
	}

	/* hashCodes */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
