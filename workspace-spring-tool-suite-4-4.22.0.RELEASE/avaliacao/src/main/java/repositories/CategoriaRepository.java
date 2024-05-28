package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
