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

import br.com.receita.domain.Endereco;
import br.com.receita.repository.filtro.EnderecoFiltro;

/**
 * @author Marcelo
 * 2 de set de 2018 
 */
@Component
public class EnderecoRepositoryImpl implements EnderecoQueriesRepository{

	/* (non-Javadoc)
	 * @see br.com.receita.repository.helper.EnderecoQueriesRepository#filtrar(br.com.receita.repository.filtro.EnderecoFiltro)
	 */
	@PersistenceContext
	private EntityManager entityManager; 
	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> filtrar(EnderecoFiltro filtro) {
		final StringBuilder builder = new StringBuilder();
		final Map<String, Object> params = new HashMap<>();
		
		builder.append("SELECT bean from Endereco bean WHERE 1 = 1");
		
		if (StringUtils.hasText(filtro.getBairro())) {
			builder.append(" and bairro = :bairro");
			params.put("bairro", filtro.getBairro());
		}
		
		Query query = entityManager.createQuery(builder.toString(), Endereco.class);
		
		for(Map.Entry<String, Object> param: params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
		
		return query.getResultList();
	}

}
