package org.generation.gamekraft.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "preco")
public class Preco {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private double valor;
	
	 @OneToMany(mappedBy = "preco", cascade = CascadeType.ALL )
		@JsonIgnoreProperties("preco")
		private List <Produto>produto;
	 
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
