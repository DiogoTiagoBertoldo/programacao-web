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

import br.com.project_abcel.abcel.access.dto.JudgementDTO;
import br.com.project_abcel.abcel.access.services.DeleteServicePlus;
import br.com.project_abcel.abcel.access.services.GetService;
import br.com.project_abcel.abcel.access.services.GetServicePlus;
import br.com.project_abcel.abcel.access.services.PostServicePlus;
import br.com.project_abcel.abcel.access.services.PutServicePlus;
import br.com.project_abcel.abcel.entities.competition.Judgement;
import br.com.project_abcel.abcel.entities.persons.Judge;
import br.com.project_abcel.abcel.entities.repository.JudgeRepository;
import br.com.project_abcel.abcel.entities.repository.JudgementRepository;

@RestController
public class JudgementController {
	@Autowired
	private JudgeRepository r;
	@Autowired
	private JudgementRepository jr;

	@GetMapping("/judgements")
	public ResponseEntity<Object> getAllJudgments() {
		return new GetService<Judgement>().getAll(jr);
	}

	@GetMapping("/judgements/{id}")
	public ResponseEntity<Object> getJudgementById(@PathVariable UUID id) {
		return new GetService<Judgement>().getById(jr, id);
	}

	@PostMapping("/judges/{id}/judgements")
	public ResponseEntity<Object> addJudgementToJudgeById(@PathVariable UUID id, @RequestBody JudgementDTO dto) {
		return new PostServicePlus<Judge, JudgementDTO, Judgement>(Judge.class, Judgement.class).post(dto, r, id);
	}

	@GetMapping("/judges/{id}/judgements")
	public ResponseEntity<Object> getAllJudgeJudgements(@PathVariable UUID id) {
		return new GetServicePlus<Judge, Judgement>().getAll(r, id);
	}

	@GetMapping("/judges/{id}/judgements/{jid}")
	public ResponseEntity<Object> getJudgementById(@PathVariable UUID id, @PathVariable UUID jid) {
		return new GetServicePlus<Judge, Judgement>().getById(r, jr, id, jid);
	}

	@PutMapping("/judges/{id}/judgements/{jid}")
	public ResponseEntity<Object> updateJudgementById(@PathVariable UUID id, @PathVariable UUID jid, JudgementDTO dto) {
		return new PutServicePlus<Judge, JudgementDTO, Judgement>().put(r, jr, id, jid, dto);
	}

	@DeleteMapping("/judges/{id}/judgements/{jid}")
	public ResponseEntity<Object> deleteJudgementById(@PathVariable UUID id, @PathVariable UUID jid) {
		return new DeleteServicePlus<Judge, Judgement>().delete(r, jr, id, jid);
	}
}
