package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
