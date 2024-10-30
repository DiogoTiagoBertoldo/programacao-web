package br.com.appvitrine.appVitrine.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.appvitrine.appVitrine.dto.ProdutoDTO;
import br.com.appvitrine.appVitrine.modelo.loja.Produto;
import br.com.appvitrine.appVitrine.modelo.repository.ProdutoRepository;

@RestController
public class ProdutoController {
	
	@Autowired
	ProdutoRepository pr;
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> salvarProduto(@RequestBody ProdutoDTO produtoDTO) {
		var produto = new Produto();
		BeanUtils.copyProperties(produtoDTO, produto);
		return ResponseEntity.status(CREATED).body(pr.save(produto));
	}
	
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> obterTodosProdutos() {
		return ResponseEntity.status(OK).body(pr.findAll());
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Object> obterProdutoPorId(@PathVariable UUID id) {
		Optional<Produto> produto = pr.findById(id);
		if(produto.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body("Produto não encontrado!");
		}
		
		return ResponseEntity.status(OK).body(produto.get());
	}
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<Object> atualizarProdutoPorId(@PathVariable UUID id,
														@RequestBody ProdutoDTO produtoDTO) {
		
		Optional<Produto> produto = pr.findById(id);
		if(produto.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body("Produto não encontrado!");
		}
		
		BeanUtils.copyProperties(produtoDTO, produto.get());
		return ResponseEntity.status(OK).body(pr.save(produto.get()));
	}
	
	@DeleteMapping("produtos/{id}")
	public ResponseEntity<Object> removerProdutoPorId(@PathVariable UUID id) {
		Optional<Produto> produto = pr.findById(id);
		if(produto.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body("Produto não encontrado!");
		}
		
		pr.deleteById(id);
		return ResponseEntity.status(OK).body("Produto removido com sucesso!");
	}
}
