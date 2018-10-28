package br.com.receita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.receita.domain.Comentario;

/**
 * @Author Marcelo Nascimento
 * @Date 27 de out de 2018
 * @Project receita
 * @Package br.com.receita.repository
 * @Desc Repositorio responsavel pelas aceos com db de comentario.
 */
public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{

}
