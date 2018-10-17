package br.com.receita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.receita.domain.Engrediente;
import br.com.receita.repository.helper.EngredienteQuerieRepository;

@Repository
public interface EngredienteRepository extends JpaRepository<Engrediente, Integer>, EngredienteQuerieRepository {

	List<Engrediente> findByDescricaoIgnoreCase(String descricao);

	/**
	 * @param id_grupo
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 16 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.repository
	 * @Desc Pesquisar ingredientes pelo grupo;
	 */
	@Query("SELECT bean FROM Engrediente bean WHERE bean.grupo.id = :grupo_id")
	List<Engrediente> listarIngredientePorGrupo(@Param("grupo_id") Integer grupo_id);

}
