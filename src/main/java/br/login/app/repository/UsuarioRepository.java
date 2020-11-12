package br.login.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.login.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);

}
