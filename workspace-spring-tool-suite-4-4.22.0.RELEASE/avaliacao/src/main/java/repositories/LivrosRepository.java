package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long>{

}
