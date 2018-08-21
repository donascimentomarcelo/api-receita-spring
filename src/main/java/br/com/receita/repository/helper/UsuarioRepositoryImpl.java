package br.com.receita.repository.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.filtro.UsuarioFiltro;

@Component
public class UsuarioRepositoryImpl implements UsuarioQueriesRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> filtrar(UsuarioFiltro filtro) {
		final StringBuilder builder = new StringBuilder();
		final Map<String, Object> params = new HashMap<>();
		
		builder.append("SELECT bean from Usuario bean where id is not null");
		
		preencherNomeSeNecessario(filtro, builder, params);
		
		preencherEmailSeNecessario(filtro, builder, params);
		
		Query query = entityManager.createQuery(builder.toString(), Usuario.class);
		
		preencherParametrosDaQuery(params, query);
		
		return query.getResultList();
	}
	
	private void preencherParametrosDaQuery(final Map<String, Object> params, Query query) {
		for(Map.Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
	}
	
	private void preencherNomeSeNecessario(
			UsuarioFiltro filtro, 
			final StringBuilder builder,
			final Map<String, Object> params) {
		
		if (StringUtils.hasText(filtro.getNome())) {
			builder.append(" and bean.nome LIKE :nome");
			params.put("nome", "%" + filtro.getNome() + "%");
		}
	}

	private void preencherEmailSeNecessario(
			UsuarioFiltro filtro, 
			final StringBuilder builder,
			final Map<String, Object> params) {
		
		if (StringUtils.hasText(filtro.getEmail())) {
			builder.append(" and bean.email LIKE :email");
			params.put("nome", "%" + filtro.getEmail() + "%");
		}
	}	
	
}
