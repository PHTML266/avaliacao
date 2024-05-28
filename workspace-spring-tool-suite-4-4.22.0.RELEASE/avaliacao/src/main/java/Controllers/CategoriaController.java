package Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import entities.Categoria;
import services.CategoriaService;

public class CategoriaController {
private final CategoriaService categoriaService;
	
	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@PostMapping
	public Categoria createCategoria(@RequestBody Categoria categoria) {
		return categoriaService.saveCategoria(categoria);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoria(@PathVariable Long idCategoria) {
		Categoria categoria = categoriaService.getCategoriaById(idCategoria);
		if (categoria != null) {
			return ResponseEntity.ok(categoria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAllLivros(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Categoria> categoria = categoriaService.getAllCategoria();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
			.body(categoria);
	}
}
