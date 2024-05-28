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

import entities.Autor;
import services.AutorService;

public class AutorController {
private final AutorService autorService;
	
	@Autowired
	public AutorController(AutorService autorService) {
		this.autorService = autorService;
	}
	
	@PostMapping
	public Autor createAutor(@RequestBody Autor autor) {
		return autorService.saveAutor(autor);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Autor> getAutor(@PathVariable Long idAutor) {
		Autor autor = autorService.getAutorById(idAutor);
		if (autor != null) {
			return ResponseEntity.ok(autor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Autor>> getAllAutor(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Autor> autor = autorService.getAllAutor();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
			.body(autor);
	}
}
