package com.manageCars.manageCars.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.manageCars.manageCars.Enuns.FormaPagamento;
import com.manageCars.manageCars.Enuns.LancamentoStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String categoria;

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime data;
	private Double valor;
	private int lancamentoStatus;
	private int formaDePagamento;

	/* Construtores */
	public Lancamento() {

	}

	public Lancamento(Long id, String descricao, String categoria, LocalDateTime data, Double valor,
			LancamentoStatus lancamentoStatus, FormaPagamento formaDePagamento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.categoria = categoria;
		this.data = data;
		this.valor = valor;
		setLancamentoStatus(lancamentoStatus);
		setFormaDePagamento(formaDePagamento);

	}

	/* gatters ande setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LancamentoStatus getLancamentoStatus() {
		return LancamentoStatus.valueOf(lancamentoStatus);
	}

	public void setLancamentoStatus(LancamentoStatus lancamentoStatus) {
		if (lancamentoStatus != null) {
			this.lancamentoStatus = lancamentoStatus.getCode();
		}
	}

	public FormaPagamento getFormaDePagamento() {
		return FormaPagamento.valueOf(formaDePagamento);
	}

	public void setFormaDePagamento(FormaPagamento formaDePagamento) {
		if (formaDePagamento != null) {
			this.formaDePagamento = formaDePagamento.getCode2();
		}
	}

	/* hash Code */
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
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
