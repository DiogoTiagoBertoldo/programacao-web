package br.com.project_abcel.abcel.access.services;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public class PutService<T, D> {
	public PutService() {

	}

	public final ResponseEntity<Object> put(JpaRepository<T, UUID> r, UUID id, D dto) {
		Optional<T> opt = r.findById(id);
		if (opt.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body(NOT_FOUND);
		}

		BeanUtils.copyProperties(dto, opt.get());
		return ResponseEntity.status(OK).body(r.save(opt.get()));
	}
}
