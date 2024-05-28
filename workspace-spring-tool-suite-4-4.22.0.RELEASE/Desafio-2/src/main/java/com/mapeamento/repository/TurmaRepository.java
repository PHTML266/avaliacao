package com.mapeamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapeamento.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	List<Turma> findByNome(String nome);
	Turma findByDescricao(String descricao);
}