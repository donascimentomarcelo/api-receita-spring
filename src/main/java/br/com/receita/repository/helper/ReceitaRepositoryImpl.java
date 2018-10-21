package br.com.receita.repository.helper;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.StringUtils;

import br.com.receita.domain.Receita;
import br.com.receita.dto.TagDTO;
import br.com.receita.repository.filtro.ReceitaFiltro;

/**
 * @Author Marcelo Nascimento
 * @Date 7 de out de 2018
 * @Project receita
 * @Package br.com.receita.repository.helper
 * @Desc 
 */
public class ReceitaRepositoryImpl implements ReceitaQueriesRepository{
	
	@PersistenceContext
	private EntityManager manager;

	/* (non-Javadoc)
	 * @see br.com.receita.repository.helper.ReceitaQueriesRepository#filtro(br.com.receita.repository.filtro.ReceitaFiltro)
	 * @param fitro
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 12:16:30
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Receita> filtro(ReceitaFiltro filtro) {
		final StringBuilder builder = new StringBuilder();
		final Map<String, Object> params = new HashMap<>();
		
		builder.append("SELECT bean FROM Receita bean WHERE 1 = 1");
		
		filtrarPorDescricao(filtro, builder, params);

		filtrarPorTitulo(filtro, builder, params);
		
		Query query = manager.createQuery(builder.toString(), Receita.class);
		
		preencheParametrosDaQuery(params, query);
		
		return query.getResultList();
	}

	/**
	 * @param params
	 * @param query
	 * @Author Marcelo Nascimento
	 * @Date 7 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.repository.helper
	 * @Desc Adiciona os parâmetros na query.
	 */
	private void preencheParametrosDaQuery(final Map<String, Object> params, Query query) {
		for (Map.Entry<String, Object> param: params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
	}

	/**
	 * @param filtro
	 * @param builder
	 * @param params
	 * @Author Marcelo Nascimento
	 * @Date 7 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.repository.helper
	 * @Desc Se necessário, adiciona where titulo.
	 */
	private void filtrarPorTitulo(ReceitaFiltro filtro, final StringBuilder builder, final Map<String, Object> params) {
		if (StringUtils.hasText(filtro.getTitulo())) {
			builder.append(" and lower(titulo) LIKE lower('%'||:titulo||'%')");
			params.put("titulo", filtro.getTitulo());
		}
	}

	/**
	 * @param filtro
	 * @param builder
	 * @param params
	 * @Author Marcelo Nascimento
	 * @Date 7 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.repository.helper
	 * @Desc Se necessário, adiciona where descricao.
	 */
	private void filtrarPorDescricao(ReceitaFiltro filtro, final StringBuilder builder,
			final Map<String, Object> params) {
		if (StringUtils.hasText(filtro.getDescricao())) {
			builder.append(" and lower(descricao) LIKE lower('%'||:descricao||'%')");
			params.put("descricao", filtro.getDescricao());
		}
	}

	/* (non-Javadoc)
	 * @see br.com.receita.repository.helper.ReceitaQueriesRepository#pesquisarReceitas(java.util.Collection)
	 * @param tags
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 22:28:41
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Receita> pesquisarReceitas(Collection<TagDTO> tags) {
		final StringBuilder builder = new StringBuilder();
		final Map<String, Object> params = new HashMap<>();
		
		builder.append("SELECT bean FROM ItemReceita itens "
				+ "INNER JOIN itens.id.receita bean "
				+ "INNER JOIN itens.id.engrediente ingrediente "
				+ "WHERE 1 = 1 ");
		
		if(tags.size() > 0) {
			for(TagDTO tag: tags) {
				builder.append("and LOWER(ingrediente.descricao) = LOWER(:descricao)");
				params.put("descricao", tag.getValor());
			}
		}
		
		Query query = manager.createQuery(builder.toString(), Receita.class);
		
		for(Map.Entry<String, Object> param: params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
		
		
		return query.getResultList();
	}

}
