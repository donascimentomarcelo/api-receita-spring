package br.com.receita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.Engrediente;
import br.com.receita.domain.ItemReceita;
import br.com.receita.domain.Receita;
import br.com.receita.dto.ItemReceitaDTO;
import br.com.receita.repository.EngredienteRepository;
import br.com.receita.repository.ItemReceitaRepository;
import br.com.receita.repository.ReceitaRepository;
import br.com.receita.service.ReceitaService;

@Service
public class ReceitaServiceImpl implements ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private EngredienteRepository engredienteRepository;  
	
	@Autowired
	private ItemReceitaRepository itemReceitaRepository;
	
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

	/* (non-Javadoc)
	 * @see br.com.receita.service.ReceitaService#pesquisar(java.lang.Integer)
	 * @param id
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 22:51:45
	 */
	@Override
	public Receita pesquisar(Integer id) {
		Receita receita = receitaRepository.findOne(id);
		return receita;
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.ReceitaService#montarReceita(java.lang.Integer, java.lang.Integer)
	 * @param idIngreceita
	 * @param idReceita
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 01:08:19
	 */
	@Override
	public void montarReceita(ItemReceita itemReceita) {

		Receita receita = itemReceita.getReceita();
		Engrediente engrediente = itemReceita.getEngrediente();
		Integer qtdd = itemReceita.getQuantidade();
		
		ItemReceita item =  new ItemReceita(receita, engrediente, qtdd);
		receita.getItens().add(itemReceita);
		
		itemReceitaRepository.save(item);
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.ReceitaService#fromDTO(br.com.receita.dto.ItemReceitaDTO)
	 * @param itemReceitaDTO
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 20:29:40
	 */
	@Override
	public ItemReceita fromDTO(ItemReceitaDTO dto) {
		ItemReceita itemReceita = new ItemReceita(dto.getReceita(), dto.getEngrediente(), dto.getQuantidade());
		return itemReceita;
	}

}
