package br.com.project_abcel.abcel.entities.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project_abcel.abcel.entities.products.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
