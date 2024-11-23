package br.com.project_abcel.abcel.access.services;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public class DeleteService<T> {

	public DeleteService() {
	}

	public final ResponseEntity<Object> delete(JpaRepository<T, UUID> r, UUID id) {
		Optional<T> opt = r.findById(id);
		if (opt.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body(NOT_FOUND);
		}

		r.deleteById(id);
		return ResponseEntity.status(OK).body("DELETE request done succesfully.");
	}
}
