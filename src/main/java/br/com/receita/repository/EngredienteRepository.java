package br.com.receita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.receita.domain.Engrediente;

@Repository
public interface EngredienteRepository extends JpaRepository<Engrediente, Integer> {

}
