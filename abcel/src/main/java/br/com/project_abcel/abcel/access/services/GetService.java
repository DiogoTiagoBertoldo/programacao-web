package br.com.project_abcel.abcel.access.services;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import br.com.project_abcel.abcel.access.utils.REB;

public class GetService<T> {
	public GetService() {
	}

	public ResponseEntity<Object> getAll(JpaRepository<T, UUID> r) {
		return new REB(OK, r.findAll()).build();
	}

	public final ResponseEntity<Object> getById(JpaRepository<T, UUID> r, UUID id) {
		Optional<T> opt = r.findById(id);
		if (opt.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		return new REB(OK, opt.get()).build();
	}
}
