package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Livros;
import repositories.LivrosRepository;

@Service
public class LivrosService {
	private final LivrosRepository livrosRepository;
	
	@Autowired
	public LivrosService(LivrosRepository livrosRepository) {
		this.livrosRepository = livrosRepository;
	}
	
	public Livros saveLivros(Livros livros) {
		return livrosRepository.save(livros);
	}
	
	public Livros getLivrosById(Long idLivros) {
		return livrosRepository.findById(idLivros).orElse(null);
	}
	
	public List<Livros> getAllLivros() {
		return livrosRepository.findAll();
	}
	
	public void deleteLivros(Long idLivros) {
		livrosRepository.deleteById(idLivros);
	}
	
}