package br.com.canalandersonandrade.forumhuboracleonealura.records;

import br.com.canalandersonandrade.forumhuboracleonealura.entity.Autor;
import br.com.canalandersonandrade.forumhuboracleonealura.entity.Curso;

import java.time.LocalDateTime;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 19/11/2024
 */
public record DadosRetornoTopico(String título, String mensagem, LocalDateTime dataDeCriacao, boolean status, Autor autor,Curso curso) {
}
