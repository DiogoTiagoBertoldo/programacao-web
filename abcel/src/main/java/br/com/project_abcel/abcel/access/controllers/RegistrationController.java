package br.com.project_abcel.abcel.access.controllers;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.project_abcel.abcel.access.dto.RegistrationDTO;
import br.com.project_abcel.abcel.access.services.GetService;
import br.com.project_abcel.abcel.access.utils.ClassInstanceHelper;
import br.com.project_abcel.abcel.access.utils.REB;
import br.com.project_abcel.abcel.entities.competition.Registration;
import br.com.project_abcel.abcel.entities.persons.Farmer;
import br.com.project_abcel.abcel.entities.repository.FarmerRepository;
import br.com.project_abcel.abcel.entities.repository.RegistrationRepository;

@Controller
public class RegistrationController {

	@Autowired
	private FarmerRepository r;
	@Autowired
	private RegistrationRepository rr;

	@GetMapping("/registrations")
	public ResponseEntity<Object> getAll() {
		return new GetService<Registration>().getAll(rr);
	}

	@GetMapping("/registrations/{id}")
	public ResponseEntity<Object> getEntityById(@PathVariable UUID id) {
		return new GetService<Registration>().getById(rr, id);
	}

	@PostMapping("/farmers/{id}/registrations")
	public ResponseEntity<Object> addRegistrationToFarmerById(@PathVariable UUID id, @RequestBody RegistrationDTO dto) {
		Optional<Farmer> farmer = r.findById(id);
		if (farmer.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		try (var cih = new ClassInstanceHelper<Registration>(Registration.class)) {
			var registration = cih.createInstance();
			BeanUtils.copyProperties(dto, registration);
			registration.setInheritance(farmer.get());
			farmer.get().addRegistration(registration);
			return new REB(OK, r.save(farmer.get())).build();
		} catch (Exception e) {
			e.printStackTrace();
			return new REB(INTERNAL_SERVER_ERROR, e).build();
		}
	}

	@GetMapping("/farmers/{id}/registrations")
	public ResponseEntity<Object> getRegistrations(@PathVariable UUID id) {
		Optional<Farmer> farmer = r.findById(id);
		if (farmer.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		return new REB(OK, farmer.get().getRegistrations()).build();
	}

	@GetMapping("/farmers/{fid}/registrations/{id}")
	public ResponseEntity<Object> getRegistrationById(@PathVariable UUID fid, @PathVariable UUID id) {
		Optional<Farmer> farmer = r.findById(fid);
		if (farmer.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		Optional<Registration> registration = rr.findById(id);
		if (registration.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		return new REB(OK, farmer.get().getRegistrations().stream().filter(reg -> reg.equals(registration.get()))
				.collect(Collectors.toList())).build();
	}

	@PutMapping("/farmers/{fid}/registrations/{id}")
	public ResponseEntity<Object> updateRegistrationById(@PathVariable UUID fid, @PathVariable UUID id,
			@RequestBody RegistrationDTO dto) {

		Optional<Farmer> farmer = r.findById(fid);
		if (farmer.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		Optional<Registration> registration = rr.findById(id);
		if (registration.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		if (farmer.get().getRegistrations().stream().anyMatch(obj -> obj.equals(registration.get()))) {
			BeanUtils.copyProperties(dto, registration.get());
			rr.save(registration.get());
			return new REB(OK, registration.get()).build();
		} else {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}
	}

	@DeleteMapping("/farmers/{fid}/registrations/{id}")
	public ResponseEntity<Object> removeRegistration(@PathVariable UUID fid, @PathVariable UUID id) {
		Optional<Farmer> farmer = r.findById(fid);
		if (farmer.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		Optional<Registration> registration = rr.findById(id);
		if (registration.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		if (farmer.get().getRegistrations().stream().anyMatch(e -> e.equals(registration.get()))) {
			farmer.get().getRegistrations().remove(registration.get());
			rr.deleteById(id);
			r.save(farmer.get());
			return new REB(OK, OK).build();
		} else {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}
	}
}
