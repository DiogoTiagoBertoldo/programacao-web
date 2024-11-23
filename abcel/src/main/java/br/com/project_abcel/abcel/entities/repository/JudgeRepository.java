package br.com.project_abcel.abcel.entities.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project_abcel.abcel.entities.persons.Judge;

@Repository
public interface JudgeRepository extends JpaRepository<Judge, UUID> {

}
