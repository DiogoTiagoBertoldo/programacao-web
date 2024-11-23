package br.com.project_abcel.abcel.entities.persons;

import static jakarta.persistence.GenerationType.AUTO;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
	@Id
	@GeneratedValue(strategy = AUTO)
	private UUID id;
	
	@Column(length = 40, nullable = false)
	private String name;
	@Column(length = 60, nullable = false)
	private String email;

	public Person() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
