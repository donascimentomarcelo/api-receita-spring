package br.com.receita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.receita.domain.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer>{

}
