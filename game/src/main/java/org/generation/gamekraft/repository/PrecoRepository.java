package org.generation.gamekraft.repository;

import java.util.List;

import org.generation.gamekraft.model.Preco;
import org.generation.gamekraft.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecoRepository extends JpaRepository<Preco, Long>{
	public List<Preco>findAllByValorContaining(double valor);
}
