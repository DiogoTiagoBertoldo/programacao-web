package br.com.project_abcel.abcel.access.services;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import br.com.project_abcel.abcel.access.utils.GenericListMethods;
import br.com.project_abcel.abcel.access.utils.REB;

public class GetServicePlus<T extends GenericListMethods<E>, E> extends GetService<T> {
	public GetServicePlus() {
	}

	public ResponseEntity<Object> getAll(JpaRepository<T, UUID> tr, UUID tdi) {
		Optional<T> opt = tr.findById(tdi);
		if (opt.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		return new REB(OK, opt.get().genericList()).build();
	}

	public ResponseEntity<Object> getById(JpaRepository<T, UUID> tr, JpaRepository<E, UUID> er, UUID tid, UUID eid) {
		Optional<T> opt = tr.findById(tid);
		if (opt.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		Optional<E> entity = er.findById(eid);
		if (entity.isEmpty()) {
			return new REB(NOT_FOUND, NOT_FOUND).build();
		}

		return new REB(OK, opt.get().genericList().stream().filter(e -> e.equals(entity.get())).findFirst()).build();
	}
}
