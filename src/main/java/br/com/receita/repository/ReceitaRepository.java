package br.com.receita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.receita.domain.Receita;
import br.com.receita.repository.helper.ReceitaQueriesRepository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer>, ReceitaQueriesRepository{

	/**
	 * @param id
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 12 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.repository
	 * @Desc Query JPQL que lista as receitas dos usuarios logados.
	 */
	@Query("SELECT bean FROM Receita bean "
			+ "LEFT JOIN bean.itens i "
			+ "WHERE bean.usuario.id = :usuario_id "
			+ "AND i IS NOT NULL "
			+ "GROUP BY bean "
			+ "ORDER BY bean.id")
	List<Receita> listarMinhasReceitasCompletas(@Param("usuario_id")Integer id);

	/**
	 * @param id
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 12 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.repository
	 * @Desc 
	 */
	@Query("SELECT bean FROM Receita bean "
			+ "LEFT JOIN bean.itens i "
			+ "WHERE bean.usuario.id = :usuario_id "
			+ "AND i IS NULL "
			+ "GROUP BY bean "
			+ "ORDER BY bean.id")
	List<Receita> listarMinhasReceitasIncompletas(@Param("usuario_id")Integer id);

}
