package com.manageCars.manageCars.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Caixa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id_caixa;
	private  String descricao;
	private Double custo;
	
	/*Constructor*/
	public Caixa() {
		
	}

	public Caixa(Long id_caixa, String descricao, Double custo) {
		super();
		this.id_caixa = id_caixa;
		this.descricao = descricao;
		this.custo = custo;
	}

	
	/*genereted gatters and setters*/
	public Long getId_caixa() {
		return id_caixa;
	}

	public void setId_caixa(Long id_caixa) {
		this.id_caixa = id_caixa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_caixa == null) ? 0 : id_caixa.hashCode());
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
		Caixa other = (Caixa) obj;
		if (id_caixa == null) {
			if (other.id_caixa != null)
				return false;
		} else if (!id_caixa.equals(other.id_caixa))
			return false;
		return true;
	}
	
	
	
	

}
