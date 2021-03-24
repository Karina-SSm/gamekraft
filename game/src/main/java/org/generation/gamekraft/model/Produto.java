package org.generation.gamekraft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	 @NotNull
	 @Size(min = 5, max = 100)
	private String nome;
	 
	@NotNull
	private int codigo;
	 @ManyToOne
	 @JsonIgnoreProperties("produto")
	 private Categoria categoria;
	 
	 @ManyToOne
	 @JsonIgnoreProperties("produto")
	 private Preco preco;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Preco getPreco() {
		return preco;
	}

	public void setPreco(Preco preco) {
		this.preco = preco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
