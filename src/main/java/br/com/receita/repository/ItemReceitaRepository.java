package br.com.receita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.receita.domain.ItemReceita;

/**
 * @Author Marcelo Nascimento
 * @Date 3 de out de 2018
 * @Project receita
 * @Package br.com.receita.repository
 * @Desc Interface de itemReceita que faz a associação das receitas com seus respectivos ingredientes.
 */
public interface ItemReceitaRepository extends JpaRepository<ItemReceita, Integer>{

}
