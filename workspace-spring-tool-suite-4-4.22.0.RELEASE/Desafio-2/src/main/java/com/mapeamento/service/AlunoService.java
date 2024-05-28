package com.mapeamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapeamento.entities.Aluno;
import com.mapeamento.repository.AlunoRepository;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    
    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }
    //Query Method
    @SuppressWarnings("unchecked")
    public List<Aluno> findAlunoByCidade(String cidade) {
        return (List<Aluno>) alunoRepository.findAlunoByCidade(cidade); 
      }
    //Query Method
    @SuppressWarnings("unchecked")
    public List<Aluno> findByNomeAndRenda(String nome, Double renda) {
        return (List<Aluno>) alunoRepository.findByNomeAndRenda(nome, renda); 
      }
    //Query Method 
    public List<Aluno> findAlunoByNome(String nome) {
        return alunoRepository.findAlunoByNome(nome); 
      }
  //Query Method
    @SuppressWarnings("unchecked")
    public List<Aluno> findByCidadeAndRenda(String cidade, Double renda) {
        return (List<Aluno>) alunoRepository.findByCidadeAndRenda(cidade,renda); 
      }
  //@query
    public List<Aluno> findByNome(String nome) {
        return alunoRepository.findAlunoByNome(nome);
    }
  //@query
    @SuppressWarnings("unchecked")
    public List<Aluno> findByNomeCompletoLike(String nomeCompleto) {
        return (List<Aluno>) alunoRepository.findByNomeLike(nomeCompleto);
    }
   //@query
    @SuppressWarnings("unchecked")
	public List<Aluno> findByAlunoId(Long id) {
        return (List<Aluno>) alunoRepository.findByAlunoId(id);
    }

    public Aluno saveAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long id, Aluno updatedAluno) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            updatedAluno.setId(id);
            return alunoRepository.save(updatedAluno);
        }
        return null;
    }

    public boolean deleteAluno(Long id) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}