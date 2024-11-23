package br.com.project_abcel.abcel.entities.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project_abcel.abcel.entities.competition.Judgement;

public interface JudgementRepository extends JpaRepository<Judgement, UUID> {
}
