package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Categoria;
import repositories.CategoriaRepository;

public class CategoriaService {
private final CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria getCategoriaById(Long idCategoria) {
		return categoriaRepository.findById(idCategoria).orElse(null);
	}
	
	public List<Categoria> getAllCategoria() {
		return categoriaRepository.findAll();
	}
	
	public void deleteCategoria(Long idCategoria) {
		categoriaRepository.deleteById(idCategoria);
	}
	
}