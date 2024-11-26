package br.com.canalandersonandrade.forumhuboracleonealura.repository;

import br.com.canalandersonandrade.forumhuboracleonealura.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("""
            SELECT u FROM Usuario u WHERE u.email = :login
                """)
    Optional<Usuario> findByLogin(String login);
}
