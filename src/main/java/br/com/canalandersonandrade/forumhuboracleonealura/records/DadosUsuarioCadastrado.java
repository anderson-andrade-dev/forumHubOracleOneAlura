package br.com.canalandersonandrade.forumhuboracleonealura.records;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
public record DadosUsuarioCadastrado(@NotNull Long id, @NotNull @NotBlank String nome, @NotNull @NotBlank @Email String email) {
}
