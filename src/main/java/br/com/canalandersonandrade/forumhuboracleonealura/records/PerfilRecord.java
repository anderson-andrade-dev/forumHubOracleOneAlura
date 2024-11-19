package br.com.canalandersonandrade.forumhuboracleonealura.records;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
public record PerfilRecord(@Nonnull @NotBlank String nome, int nivel) {
}
