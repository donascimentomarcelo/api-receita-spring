package br.com.receita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.receita.domain.Endereco;
import br.com.receita.repository.helper.EnderecoQueriesRepository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>, EnderecoQueriesRepository{

}
