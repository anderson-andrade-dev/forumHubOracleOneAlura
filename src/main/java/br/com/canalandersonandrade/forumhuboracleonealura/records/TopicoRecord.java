package br.com.canalandersonandrade.forumhuboracleonealura.records;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
public record TopicoRecord(String titulo,String mensagem,String dataCriacao,boolean status,AutorRecord autor,CursoRecord curso) {
}
