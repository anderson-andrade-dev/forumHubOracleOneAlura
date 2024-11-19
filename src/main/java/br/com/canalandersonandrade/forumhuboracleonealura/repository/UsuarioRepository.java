package br.com.canalandersonandrade.forumhuboracleonealura.repository;

import br.com.canalandersonandrade.forumhuboracleonealura.entity.Perfil;
import br.com.canalandersonandrade.forumhuboracleonealura.entity.Usuario;
import br.com.canalandersonandrade.forumhuboracleonealura.records.PerfilRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
