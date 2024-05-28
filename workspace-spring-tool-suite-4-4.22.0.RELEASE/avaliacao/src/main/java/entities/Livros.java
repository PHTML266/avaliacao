package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Livros")
public class Livros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLivros;
	
	@Column
	private String Titulo;
	
	@Column
	private String Ano;

	public Long getIdLivros() {
		return idLivros;
	}

	public void setIdLivros(Long idLivros) {
		this.idLivros = idLivros;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getAno() {
		return Ano;
	}

	public void setAno(String ano) {
		Ano = ano;
	}
}
