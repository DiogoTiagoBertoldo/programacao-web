package br.com.project_abcel.abcel.entities.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project_abcel.abcel.entities.competition.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, UUID> {

}
