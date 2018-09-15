package br.com.receita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.Engrediente;
import br.com.receita.repository.EngredienteRepository;
import br.com.receita.repository.filtro.EngredienteFiltro;
import br.com.receita.service.EngredienteService;
import br.com.receita.service.exception.ObjetoNaoEncontradoException;

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

	/* (non-Javadoc)
	 * @see br.com.receita.service.EngredienteService#atualizar(br.com.receita.domain.Engrediente)
	 * @param engrediente
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 20:53:32
	 */
	@Override
	public void atualizar(Engrediente engrediente) {
		engredienteRepository.save(engrediente);
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.EngredienteService#listar()
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 21:29:49
	 */
	@Override
	public List<Engrediente> listar() {
		return engredienteRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.EngredienteService#pesquisar(java.lang.Integer)
	 * @param id
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 00:20:43
	 */
	@Override
	public Engrediente pesquisar(Integer id) {
		Engrediente engrediente = engredienteRepository.findOne(id);
		if(engrediente == null) {
			throw new ObjetoNaoEncontradoException("Ingrediente não encontrado");
		}
		
		return engrediente;
	}

}
