package br.com.project_abcel.abcel.access.services;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import br.com.project_abcel.abcel.access.utils.ClassInstanceHelper;
import br.com.project_abcel.abcel.access.utils.GenericListMethods;
import br.com.project_abcel.abcel.access.utils.SetGenericInheritance;

public class PostServicePlus<T extends GenericListMethods<E>, D, E extends SetGenericInheritance<T>>
		extends PostService<T, D> {

	private Class<E> entity;

	public PostServicePlus(Class<T> type, Class<E> entity) {
		super(type);
		this.entity = entity;
	}

	public ResponseEntity<Object> post(D dto, JpaRepository<T, UUID> r, UUID id) {
		Optional<T> opt = r.findById(id);
		if (opt.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).body(NOT_FOUND);
		}

		try (var cih = new ClassInstanceHelper<E>(entity)) {
			var obj = cih.createInstance();
			BeanUtils.copyProperties(dto, obj);
			obj.setInheritance(opt.get());
			opt.get().add(obj);
			r.save(opt.get());
			return ResponseEntity.status(OK).body(opt.get());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(e.getCause());
		}
	}
}
