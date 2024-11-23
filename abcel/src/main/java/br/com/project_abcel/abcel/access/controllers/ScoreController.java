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

import br.com.project_abcel.abcel.access.dto.ScoreDTO;
import br.com.project_abcel.abcel.access.services.DeleteServicePlus;
import br.com.project_abcel.abcel.access.services.GetServicePlus;
import br.com.project_abcel.abcel.access.services.PostServicePlus;
import br.com.project_abcel.abcel.access.services.PutServicePlus;
import br.com.project_abcel.abcel.entities.competition.Judgement;
import br.com.project_abcel.abcel.entities.competition.Score;
import br.com.project_abcel.abcel.entities.repository.JudgementRepository;
import br.com.project_abcel.abcel.entities.repository.ScoreRepository;

@RestController
public class ScoreController {

	@Autowired
	private JudgementRepository jr;
	@Autowired
	private ScoreRepository r;

	@GetMapping("/judgements/{jid}/scores")
	public ResponseEntity<Object> getAll(@PathVariable UUID jid) {
		return new GetServicePlus<Judgement, Score>().getAll(jr, jid);
	}

	@GetMapping("/judgements/{jid}/scores/{id}")
	public ResponseEntity<Object> getById(@PathVariable UUID jid, @PathVariable UUID id) {
		return new GetServicePlus<Judgement, Score>().getById(jr, r, jid, id);
	}

	@PostMapping("/judgements/{jid}/scores")
	public ResponseEntity<Object> addScore(@PathVariable UUID jid, @RequestBody ScoreDTO dto) {
		return new PostServicePlus<Judgement, ScoreDTO, Score>(Judgement.class, Score.class).post(dto, jr, jid);
	}

	@PutMapping("/judgements/{jid}/scores/{id}")
	public ResponseEntity<Object> updateScore(@PathVariable UUID jid, @PathVariable UUID id,
			@RequestBody ScoreDTO dto) {
		return new PutServicePlus<Judgement, ScoreDTO, Score>().put(jr, r, jid, id, dto);
	}

	@DeleteMapping("/judgements/{jid}/scores/{id}")
	public ResponseEntity<Object> deleteScore(@PathVariable UUID jid, @PathVariable UUID id) {
		return new DeleteServicePlus<Judgement, Score>().delete(jr, r, jid, id);
	}
}
