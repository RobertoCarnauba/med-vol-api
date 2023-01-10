package med.vol.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import med.vol.api.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	UserDetails findByLogin(String login);
}
