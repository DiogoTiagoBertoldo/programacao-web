package br.com.project_abcel.abcel.access.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class REB {

	private final HttpStatus status;
	private final Object body;

	public REB(HttpStatus status, Object body) {
		this.status = status;
		this.body = body;
	}

	public final ResponseEntity<Object> build() {
		return ResponseEntity.status(status).body(body);
	}
}
