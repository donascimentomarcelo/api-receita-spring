/**
 * 
 */
package br.com.receita.repository.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.receita.domain.Engrediente;
import br.com.receita.repository.filtro.EngredienteFiltro;

/**
 * @Author Marcelo Nascimento
 * @Date 7 de set de 2018
 * @Project receita
 * @Package br.com.receita.serviceTest
 */
@Component
public class EngredienteRepositoryImpl implements EngredienteQuerieRepository{
	
	@PersistenceContext
	private EntityManager entityManager; 
	
	/* (non-Javadoc)
	 * @see br.com.receita.repository.helper.EngredienteQuerieRepository#filtro(br.com.receita.repository.filtro.EngredienteFiltro)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Engrediente> filtro(EngredienteFiltro filtro) {
		final StringBuilder builder = new StringBuilder();
		final Map<String, Object> params = new HashMap<>();
		
		builder.append("SELECT bean FROM Engrediente bean WHERE 1 = 1");
		
		seDescricaoExistir(filtro, builder, params);

		seQuantidadeExistir(filtro, builder, params);

		seMedidaExistir(filtro, builder, params);
		
		Query query = entityManager.createQuery(builder.toString(), Engrediente.class);
		
		preencherParametrosDaQuery(params, query);
		
		return query.getResultList();
	}

	/**
	 * @param filtro
	 * @param builder
	 * @param params
	 * @Author Marcelo Nascimento
	 * @Date 7 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.repository.helper
	 * @Desc Adiciona "where descricao" caso a descricao não seja vazia
	 */
	private void seDescricaoExistir(EngredienteFiltro filtro, final StringBuilder builder,
			final Map<String, Object> params) {
		if (StringUtils.hasText(filtro.getDescricao())) {
			builder.append(" and descricao = :descricao");
			params.put("descricao", filtro.getDescricao());
		}
	}

	/**
	 * @param filtro
	 * @param builder
	 * @param params
	 * @Author Marcelo Nascimento
	 * @Date 7 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.repository.helper
	 * @Desc Adiciona "where quantidade" caso a quantidade não seja vazia
	 */
	private void seQuantidadeExistir(EngredienteFiltro filtro, final StringBuilder builder,
			final Map<String, Object> params) {
		if (filtro.getQuantidade() != null) {
			builder.append(" and quantidade = :quantidade");
			params.put("quantidade", filtro.getQuantidade());
		}
	}

	/**
	 * @param filtro
	 * @param builder
	 * @param params
	 * @Author Marcelo Nascimento
	 * @Date 7 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.repository.helper
	 * @Desc Adiciona "where medida" caso a medida não seja vazia
	 */
	private void seMedidaExistir(EngredienteFiltro filtro, final StringBuilder builder,
			final Map<String, Object> params) {
		if (filtro.getMedida() != null) {
			builder.append(" and medida = :medida");
			params.put("medida", filtro.getMedida().getCodigo());
		}
	}

	/**
	 * @param params
	 * @param query
	 * @Author Marcelo Nascimento
	 * @Date 7 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.repository.helper
	 * @Desc Faz uma varredura nos parametros e preenche a query
	 */
	private void preencherParametrosDaQuery(final Map<String, Object> params, Query query) {
		for (Map.Entry<String, Object> param: params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
	}

}
