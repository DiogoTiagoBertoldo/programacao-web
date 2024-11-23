package br.com.project_abcel.abcel.access.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project_abcel.abcel.access.dto.ProductDTO;
import br.com.project_abcel.abcel.access.services.DeleteServicePlus;
import br.com.project_abcel.abcel.access.services.GetService;
import br.com.project_abcel.abcel.access.services.GetServicePlus;
import br.com.project_abcel.abcel.access.services.PostServicePlus;
import br.com.project_abcel.abcel.access.services.PutServicePlus;
import br.com.project_abcel.abcel.entities.persons.Farmer;
import br.com.project_abcel.abcel.entities.products.Product;
import br.com.project_abcel.abcel.entities.repository.FarmerRepository;
import br.com.project_abcel.abcel.entities.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private FarmerRepository r;
	@Autowired
	private ProductRepository pr;

	@GetMapping("/products")
	public ResponseEntity<Object> getAllProducts() {
		return new GetService<Product>().getAll(pr);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable UUID id) {
		return new GetService<Product>().getById(pr, id);
	}

	@PostMapping("farmers/{id}/products")
	public ResponseEntity<Object> addProductToFarmerById(@PathVariable UUID id, @RequestBody ProductDTO dto) {
		return new PostServicePlus<Farmer, ProductDTO, Product>(Farmer.class, Product.class).post(dto, r, id);
	}

	@GetMapping("farmers/{id}/products")
	public ResponseEntity<Object> getProducts(@PathVariable UUID id) {
		return new GetServicePlus<Farmer, Product>().getAll(r, id);
	}

	@GetMapping("farmers/{fid}/products/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable UUID fid, @PathVariable UUID id) {
		return new GetServicePlus<Farmer, Product>().getById(r, pr, fid, id);
	}

	@PutMapping("farmers/{fid}/products/{id}")
	public ResponseEntity<Object> updateProductById(@PathVariable UUID fid, @PathVariable UUID id,
			@RequestBody ProductDTO dto) {
		return new PutServicePlus<Farmer, ProductDTO, Product>().put(r, pr, fid, id, dto);
	}

	@DeleteMapping("farmers/{fid}/products/{id}")
	public ResponseEntity<Object> removeProduct(@PathVariable UUID fid, @PathVariable UUID id) {
		return new DeleteServicePlus<Farmer, Product>().delete(r, pr, fid, id);
	}
}
