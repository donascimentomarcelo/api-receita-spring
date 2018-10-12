package br.com.receita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.receita.domain.Grupo;

/**
 * @Author Marcelo Nascimento
 * @Date 9 de out de 2018
 * @Project receita
 * @Package br.com.receita.repository
 * @Desc Repositorio de grupo.
 */
public interface GrupoRepository extends JpaRepository<Grupo, Integer>{

}
