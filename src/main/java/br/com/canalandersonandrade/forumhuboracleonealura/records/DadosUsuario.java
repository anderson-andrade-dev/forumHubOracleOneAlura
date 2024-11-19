package br.com.canalandersonandrade.forumhuboracleonealura.records;

import java.util.List;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
public record DadosUsuario(String nome, String email, String senha, List<PerfilRecord> perfils) {
}
