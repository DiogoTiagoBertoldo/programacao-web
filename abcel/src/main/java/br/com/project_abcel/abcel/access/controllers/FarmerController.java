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

import br.com.project_abcel.abcel.access.dto.FarmerDTO;
import br.com.project_abcel.abcel.access.services.DeleteService;
import br.com.project_abcel.abcel.access.services.GetService;
import br.com.project_abcel.abcel.access.services.PostService;
import br.com.project_abcel.abcel.access.services.PutService;
import br.com.project_abcel.abcel.entities.persons.Farmer;
import br.com.project_abcel.abcel.entities.repository.FarmerRepository;

@RestController
public class FarmerController {

	@Autowired
	private FarmerRepository r;

	@PostMapping("/farmers")
	public ResponseEntity<Object> addFarmer(@RequestBody FarmerDTO dto) {
		return new PostService<Farmer, FarmerDTO>(Farmer.class).post(dto, r);
	}

	@GetMapping("/farmers")
	public ResponseEntity<Object> getAllFarmers() {
		return new GetService<Farmer>().getAll(r);
	}

	@GetMapping("/farmers/{id}")
	public ResponseEntity<Object> getFarmerById(@PathVariable UUID id) {
		return new GetService<Farmer>().getById(r, id);
	}

	@PutMapping("/farmers/{id}")
	public ResponseEntity<Object> updateFarmerById(@PathVariable UUID id, @RequestBody FarmerDTO dto) {
		return new PutService<Farmer, FarmerDTO>().put(r, id, dto);
	}

	@DeleteMapping("/farmers/{id}")
	public ResponseEntity<Object> removeFarmerById(@PathVariable UUID id) {
		return new DeleteService<Farmer>().delete(r, id);
	}
}
