package br.com.receita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.receita.domain.Engrediente;
import br.com.receita.repository.helper.EngredienteQuerieRepository;

@Repository
public interface EngredienteRepository extends JpaRepository<Engrediente, Integer>, EngredienteQuerieRepository {

	List<Engrediente> findByDescricaoIgnoreCase(String descricao);

}
