package br.com.receita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.Receita;
import br.com.receita.repository.ReceitaRepository;
import br.com.receita.service.ReceitaService;

@Service
public class ReceitaServiceImpl implements ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;
	
	public ReceitaServiceImpl(ReceitaRepository receitaRepository) {
		this.receitaRepository = receitaRepository;
	}

	@Override
	public List<Receita> listar() {
		List<Receita> lista = receitaRepository.findAll();
		return lista;
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.ReceitaService#salvar(br.com.receita.domain.Receita)
	 * @param receita
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 22:23:47
	 */
	@Override
	public Receita salvar(Receita receita) {
		receita = receitaRepository.save(receita);
		return receita;
	}

}
