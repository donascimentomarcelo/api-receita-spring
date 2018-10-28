package br.com.receita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.receita.domain.Avaliacao;

/**
 * @Author Marcelo Nascimento
 * @Date 27 de out de 2018
 * @Project receita
 * @Package br.com.receita.repository
 * @Desc Repositorio responsavel pelas aceos com db de acaliacao
 */
@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer>{

}
