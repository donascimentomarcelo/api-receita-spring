package br.com.receita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.Engrediente;
import br.com.receita.repository.EngredienteRepository;
import br.com.receita.repository.filtro.EngredienteFiltro;
import br.com.receita.service.EngredienteService;

@Service
public class EngredienteServiceImpl implements EngredienteService{

	@Autowired
	private EngredienteRepository engredienteRepository;
	
	public EngredienteServiceImpl(EngredienteRepository engredienteRepository) {
		this.engredienteRepository = engredienteRepository;
	}

	@Override
	public Engrediente salvar(Engrediente engrediente) {
		engrediente = engredienteRepository.save(engrediente);
		return engrediente;
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.EngredienteService#filtrar(br.com.receita.repository.filtro.EngredienteFiltro)
	 */
	@Override
	public List<Engrediente> filtrar(EngredienteFiltro filtro) {
		List<Engrediente> lista = engredienteRepository.filtro(filtro);
		return lista;
	}

}
