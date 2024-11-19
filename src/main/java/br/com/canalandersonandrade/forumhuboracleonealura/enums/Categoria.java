package br.com.canalandersonandrade.forumhuboracleonealura.enums;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
public enum Categoria {
    PROGRAMACAO("Programação"),
    BANCO_DE_DADOS("Banco de dados");

    private final String categoria;

    Categoria(String categoria) {
        this.categoria = categoria;
    }
}
