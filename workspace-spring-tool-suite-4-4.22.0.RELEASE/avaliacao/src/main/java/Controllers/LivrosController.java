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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Livros;
import services.LivrosService;

@RestController
@RequestMapping("/Livros")
public class LivrosController {	
private final LivrosService livrosService;
	
	@Autowired
	public LivrosController(LivrosService livrosService) {
		this.livrosService = livrosService;
	}
	
	@PostMapping
	public Livros createLivros(@RequestBody Livros livros) {
		return livrosService.saveLivros(livros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livros> getLivros(@PathVariable Long idLivros) {
		Livros livros = livrosService.getLivrosById(idLivros);
		if (livros != null) {
			return ResponseEntity.ok(livros);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Livros>> getAllLivros(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Livros> livros = livrosService.getAllLivros();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
			.body(livros);
	}
}
