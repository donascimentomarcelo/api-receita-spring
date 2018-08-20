package br.com.receita.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.helper.UsuarioRepositoryQueries;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>, UsuarioRepositoryQueries{

	Optional<Usuario> findByEmail(String email);

	Optional<Usuario> findById(Integer codigo);

}
