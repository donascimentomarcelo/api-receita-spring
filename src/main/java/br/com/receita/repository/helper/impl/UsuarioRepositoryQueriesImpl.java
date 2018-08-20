package br.com.receita.repository.helper.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.filtro.UsuarioFiltro;
import br.com.receita.repository.helper.UsuarioRepositoryQueries;

@Service
public class UsuarioRepositoryQueriesImpl implements UsuarioRepositoryQueries{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> filtrar(UsuarioFiltro filtro) {
		StringBuilder builder = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		builder.append("SELECT bean from Usuario bean where id is not null");
		
		if (StringUtils.hasText(filtro.getNome())) {
			builder.append(" and bean.nome LIKE :nome");
			params.put("nome", "%" + filtro.getNome() + "%");
		}
		
		if (StringUtils.hasText(filtro.getEmail())) {
			builder.append(" and bean.email LIKE :email");
			params.put("nome", "%" + filtro.getEmail() + "%");
		}
		
		Query query = entityManager.createQuery(builder.toString(), Usuario.class);
		
		for(Map.Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
		
		return query.getResultList();
	}
	
	
}
