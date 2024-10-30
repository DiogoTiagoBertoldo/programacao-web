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

import br.com.appvitrine.appVitrine.dto.PerfilDTO;
import br.com.appvitrine.appVitrine.modelo.acesso.Perfil;
import br.com.appvitrine.appVitrine.modelo.repository.PerfilRepository;
import jakarta.validation.Valid;

@RestController
public class PerfilController {

	@Autowired
	PerfilRepository pr;
	
	@PostMapping("/perfil")
	public ResponseEntity<Perfil> salvarPerfil(@RequestBody @Valid PerfilDTO perfilDTO) {
		var perfil = new Perfil();
		BeanUtils.copyProperties(perfilDTO, perfil);
		
		return ResponseEntity.status(CREATED).body(pr.save(perfil));
	}
	
	@GetMapping("/perfil")
	public ResponseEntity<List<Perfil>> obterTodosPerfis() {
		return ResponseEntity.status(OK).body(pr.findAll());
	}
	
	@GetMapping("/perfil/{id}")
	public ResponseEntity<Object> obterPerfilPorId(@PathVariable UUID id) {
		Optional<Perfil> perfil = pr.findById(id);
		if(perfil.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body("Perfil não encontrado!");
		}
		
		return ResponseEntity.status(OK).body(perfil.get());
	}
	
	@PutMapping("/perfil/{id}")
	public ResponseEntity<Object> atualizarPerfilPorId(@PathVariable UUID id,
														@RequestBody PerfilDTO perfilDTO) {
		
		Optional<Perfil> perfil = pr.findById(id);
		if(perfil.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body("Perfil não encontrado!");
		}
		
		BeanUtils.copyProperties(perfilDTO, perfil.get());
		return ResponseEntity.status(OK).body(pr.save(perfil.get()));
	}
	
	@DeleteMapping("/perfil/{id}")
	public ResponseEntity<Object> removerProdutoPorId(@PathVariable UUID id) {
		Optional<Perfil> perfil = pr.findById(id);
		if(perfil.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body("Perfil não encontrado!");
		}
		
		pr.deleteById(id);
		return ResponseEntity.status(OK).body("Perfil removido com sucesso!");
	}
}
