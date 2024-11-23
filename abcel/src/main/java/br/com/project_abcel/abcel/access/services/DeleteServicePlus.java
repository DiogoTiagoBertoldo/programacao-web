package br.com.project_abcel.abcel.access.services;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import br.com.project_abcel.abcel.access.utils.GenericListMethods;

public class DeleteServicePlus<T extends GenericListMethods<E>, E> {
	public ResponseEntity<Object> delete(JpaRepository<T, UUID> tr, JpaRepository<E, UUID> er, UUID tid, UUID eid) {
		Optional<T> topt = tr.findById(tid);
		if (topt.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body(NOT_FOUND);
		}

		Optional<E> eopt = er.findById(eid);
		if (eopt.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body(NOT_FOUND);
		}
		
		if(topt.get().genericList().stream().anyMatch(e -> e.equals(eopt.get()))) {
			topt.get().genericList().remove(eopt.get());
			er.deleteById(eid);
			tr.save(topt.get());
			return ResponseEntity.status(OK).body("DELETE request done succesfully.");
		} else {
			return ResponseEntity.status(NOT_FOUND).body(NOT_FOUND);
		}
	}
}
