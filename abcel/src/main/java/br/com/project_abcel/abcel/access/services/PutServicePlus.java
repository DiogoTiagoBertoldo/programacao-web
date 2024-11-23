package br.com.project_abcel.abcel.access.services;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import br.com.project_abcel.abcel.access.utils.GenericListMethods;

public class PutServicePlus<T extends GenericListMethods<E>, D, E> extends PutService<T, D> {
	public PutServicePlus() {
	}

	public ResponseEntity<Object> put(JpaRepository<T, UUID> tr, JpaRepository<E, UUID> er, UUID tid, UUID eid, D dto) {
		Optional<T> opt = tr.findById(tid);
		if (opt.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body(NOT_FOUND);
		}

		Optional<E> entity = er.findById(eid);
		if (entity.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body(NOT_FOUND);
		}

		if (opt.get().genericList().stream().anyMatch(obj -> obj.equals(entity.get()))) {
			BeanUtils.copyProperties(dto, entity.get());
			er.save(entity.get());
			return ResponseEntity.status(OK).body(entity.get());
		} else {
			return ResponseEntity.status(NOT_FOUND).body(NOT_FOUND);
		}
	}
}
