package com.mapeamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mapeamento.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	//Query Methods
	List<Aluno> findAlunoByNome(String nome);
	Aluno findByRa(String ra);
	Aluno findByAlunoId(Long id);
	Aluno findAlunoByCidade(String cidade);
	Aluno findByNomeAndRenda(String nome, Double renda);
	Aluno findByCidadeAndRenda(String cidade, Double renda);
	Aluno findByNomeLike(String nomeCompleto);

}