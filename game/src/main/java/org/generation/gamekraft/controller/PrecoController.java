package org.generation.gamekraft.controller;

import java.util.List;

import org.generation.gamekraft.model.Preco;
import org.generation.gamekraft.model.Produto;
import org.generation.gamekraft.repository.PrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/preco")
@CrossOrigin(origins = "*")
public class PrecoController {
	@Autowired
	private PrecoRepository repository;
	 @GetMapping
		public ResponseEntity<List<Preco>> getAll(){
			return ResponseEntity.ok(repository.findAll());
		}
	 public ResponseEntity<Preco> getById(@PathVariable long id){
		 return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		 
	 }
	 @GetMapping("/valor/{valor}")
	 public ResponseEntity<List<Preco>> getByName(@PathVariable double valor){
		 return ResponseEntity.ok(repository.findAllByValorContaining(valor));
	 }
	 @PostMapping
		public ResponseEntity<Preco> post(@RequestBody Preco preco){
		 return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(preco));
		  
	 }
	 @PutMapping
		public ResponseEntity<Preco> put(@RequestBody Preco preco){
			 return ResponseEntity.ok(repository.save(preco));
		 }
		 @DeleteMapping("/{id}")
			public void delete (@PathVariable long id) {
				repository.deleteById(id);
			}
}
