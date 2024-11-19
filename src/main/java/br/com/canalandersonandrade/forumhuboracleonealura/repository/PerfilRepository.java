package br.com.canalandersonandrade.forumhuboracleonealura.repository;

import br.com.canalandersonandrade.forumhuboracleonealura.entity.Perfil;
import br.com.canalandersonandrade.forumhuboracleonealura.records.PerfilRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 19/11/2024
 */
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Optional<Perfil> findByNomeEqualsIgnoreCase(String nome);
}
