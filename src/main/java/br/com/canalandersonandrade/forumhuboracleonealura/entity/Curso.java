package br.com.canalandersonandrade.forumhuboracleonealura.entity;

import br.com.canalandersonandrade.forumhuboracleonealura.enums.Categoria;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String nome;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Deprecated
    protected Curso() {
        //Obrigatorio JPA
    }

    public Curso(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public Curso(@Nonnull @Negative Long id, @Nonnull @NotBlank String nome, @Nonnull @NotBlank String categoria) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) && Objects.equals(nome, curso.nome) && Objects.equals(categoria, curso.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, categoria);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
