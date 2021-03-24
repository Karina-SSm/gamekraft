package org.generation.gamekraft.model;


import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	 @NotNull
	 @Size(min = 5, max = 100)
	private String descricao;
	 
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataconsulta = new java.sql.Date(System.currentTimeMillis());
	
	 @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL )
		@JsonIgnoreProperties("categoria")
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataconsulta() {
		return dataconsulta;
	}

	public void setDataconsulta(Date dataconsulta) {
		this.dataconsulta = dataconsulta;
	}
		 
	 

	

}


