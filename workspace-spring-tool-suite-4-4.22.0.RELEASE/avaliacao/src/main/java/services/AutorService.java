package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Autor;
import repositories.AutorRepository;

public class AutorService {
private final AutorRepository autorRepository;
	
	@Autowired
	public AutorService(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	public Autor saveAutor(Autor autor) {
		return autorRepository.save(autor);
	}
	
	public Autor getAutorById(Long idAutor) {
		return autorRepository.findById(idAutor).orElse(null);
	}
	
	public List<Autor> getAllAutor() {
		return autorRepository.findAll();
	}
	
	public void deleteAutor(Long idAutor) {
		autorRepository.deleteById(idAutor);
	}
	
}