package br.com.project_abcel.abcel.entities.persons;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.project_abcel.abcel.access.utils.GenericListMethods;
import br.com.project_abcel.abcel.entities.competition.Registration;
import br.com.project_abcel.abcel.entities.products.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Farmer")
public class Farmer extends Person implements Serializable, GenericListMethods<Product> {
	@Serial
	private static final long serialVersionUID = 1L;

	@Column(length = 30, nullable = false)
	private String city;
	@Column(length = 30, nullable = false)
	private String neighborhood;
	@Column(length = 13, nullable = false)
	private long phone;

	@OneToMany(fetch = LAZY, mappedBy = "farmer", cascade = ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Product> products;
	@OneToMany(fetch = LAZY, mappedBy = "farmer", cascade = ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Registration> registrations;

	public Farmer() {
	}

	@Override
	public void add(Product e) {
		addProduct(e);
	}

	@Override
	public List<Product> genericList() {
		return products;

	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void addRegistration(Registration registration) {
		registrations.add(registration);
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
}
