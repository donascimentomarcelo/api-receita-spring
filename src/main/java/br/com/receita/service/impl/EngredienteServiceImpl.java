package br.com.receita.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.Engrediente;
import br.com.receita.repository.EngredienteRepository;
import br.com.receita.service.EngredienteService;

@Service
public class EngredienteServiceImpl implements EngredienteService {

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

}
