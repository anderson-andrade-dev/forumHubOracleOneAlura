package br.com.canalandersonandrade.forumhuboracleonealura.repository;

import br.com.canalandersonandrade.forumhuboracleonealura.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}
