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
	
	@Override
	public List<Receita> listar() {
		List<Receita> lista = receitaRepository.findAll();
		return lista;
	}

}
