package br.com.receita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.Grupo;
import br.com.receita.repository.GrupoRepository;
import br.com.receita.service.GrupoService;

/**
 * @Author Marcelo Nascimento
 * @Date 10 de out de 2018
 * @Project receita
 * @Package br.com.receita.service.impl
 * @Desc Classe de implementações dos serviços de grupo.
 */
@Service
public class GrupoServiceImpl implements GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;
	/* (non-Javadoc)
	 * @see br.com.receita.service.GrupoService#listar()
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 22:23:43
	 */
	@Override
	public List<Grupo> listar() {
		return grupoRepository.findAll();
	}

}
