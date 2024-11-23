package br.com.project_abcel.abcel.access.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project_abcel.abcel.access.dto.JudgeDTO;
import br.com.project_abcel.abcel.access.services.DeleteService;
import br.com.project_abcel.abcel.access.services.GetService;
import br.com.project_abcel.abcel.access.services.PostService;
import br.com.project_abcel.abcel.access.services.PutService;
import br.com.project_abcel.abcel.entities.persons.Judge;
import br.com.project_abcel.abcel.entities.repository.JudgeRepository;

@RestController
public class JudgeController {

	@Autowired
	private JudgeRepository r;

	@PostMapping("/judges")
	public ResponseEntity<Object> addJudge(@RequestBody JudgeDTO dto) {
		return new PostService<Judge, JudgeDTO>(Judge.class).post(dto, r);
	}

	@GetMapping("/judges")
	public ResponseEntity<Object> getAllJudges() {
		return new GetService<Judge>().getAll(r);
	}

	@GetMapping("/judges/{id}")
	public ResponseEntity<Object> getJudgeById(@PathVariable UUID id) {
		return new GetService<Judge>().getById(r, id);
	}

	@PutMapping("/judges/{id}")
	public ResponseEntity<Object> updateJudgeById(@PathVariable UUID id, @RequestBody JudgeDTO dto) {
		return new PutService<Judge, JudgeDTO>().put(r, id, dto);
	}

	@DeleteMapping("/judges/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable UUID id) {
		return new DeleteService<Judge>().delete(r, id);
	}
}