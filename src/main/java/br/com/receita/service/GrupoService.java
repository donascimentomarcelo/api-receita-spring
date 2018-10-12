package br.com.receita.service;

import java.util.List;

import br.com.receita.domain.Grupo;

/**
 * @Author Marcelo Nascimento
 * @Date 10 de out de 2018
 * @Project receita
 * @Package br.com.receita.service
 * @Desc Interface que chama serviço de curso.
 */
public interface GrupoService {

	/**
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 10 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Metodo que lista todos os grupos, mas sem paginar.
	 */
	List<Grupo> listar();

}
