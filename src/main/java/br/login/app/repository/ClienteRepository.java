package br.login.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.login.app.model.Cliente;
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
