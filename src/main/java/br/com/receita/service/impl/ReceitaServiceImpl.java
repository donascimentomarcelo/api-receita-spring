package br.com.receita.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.ItemReceita;
import br.com.receita.domain.Receita;
import br.com.receita.domain.Usuario;
import br.com.receita.dto.ItemReceitaDTO;
import br.com.receita.dto.TagDTO;
import br.com.receita.repository.ItemReceitaRepository;
import br.com.receita.repository.ReceitaRepository;
import br.com.receita.repository.filtro.ReceitaFiltro;
import br.com.receita.service.ReceitaService;
import br.com.receita.service.UsuarioService;

@Service
public class ReceitaServiceImpl implements ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private ItemReceitaRepository itemReceitaRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
	public Receita salvar(Receita receita) throws Exception {
		Usuario usuario = usuarioService.pesquisaUsuarioLogado();
		receita.setUsuario(usuario);
		receita = receitaRepository.save(receita);
		return receita;
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
		
		itemReceitaRepository.save(itemReceita);
	}



	/* (non-Javadoc)
	 * @see br.com.receita.service.ReceitaService#desmontarReceita(br.com.receita.domain.ItemReceita)
	 * @param itemReceita
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 20:44:24
	 */
	@Override
	public void desmontarReceita(ItemReceita itemReceita) {
		
		itemReceitaRepository.delete(itemReceita);
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.ReceitaService#filtro(br.com.receita.repository.filtro.ReceitaFiltro)
	 * @param filtro
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 12:11:27
	 */
	@Override
	public List<Receita> filtro(ReceitaFiltro filtro) {
		List<Receita> lista = receitaRepository.filtro(filtro);
		return lista;
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.ReceitaService#minhasReceitas()
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 00:07:43
	 */
	@Override
	public List<Receita> minhasReceitasCompletas() throws Exception {
		Usuario usuario = usuarioService.pesquisaUsuarioLogado();
		List<Receita> lista = receitaRepository.listarMinhasReceitasCompletas(usuario.getId());
		return lista;
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.ReceitaService#minhasReceitasIncompletas()
	 * @return
	 * @throws Exception
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 16:27:20
	 */
	@Override
	public List<Receita> minhasReceitasIncompletas() throws Exception {
		Usuario usuario = usuarioService.pesquisaUsuarioLogado();
		List<Receita> lista = receitaRepository.listarMinhasReceitasIncompletas(usuario.getId());
		return lista;
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.ReceitaService#atualizar(br.com.receita.domain.Receita, java.lang.Integer)
	 * @param receita
	 * @param id
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 22:15:33
	 */
	@Override
	public void atualizar(Receita receita, Integer id) {
		Receita rec = pesquisar(id);
		rec.setId(id);
		rec.setDescricao(receita.getDescricao());
		rec.setTitulo(receita.getTitulo());
		receitaRepository.save(receita);
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.ReceitaService#pesquisarReceitas(java.util.Collection)
	 * @param tags
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 22:21:40
	 */
	@Override
	public List<Receita> pesquisarReceitas(Collection<TagDTO> tags) {
		return receitaRepository.pesquisarReceitas(tags);
	}

}
