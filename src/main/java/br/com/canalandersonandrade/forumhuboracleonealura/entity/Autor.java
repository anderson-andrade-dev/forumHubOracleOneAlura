package br.com.canalandersonandrade.forumhuboracleonealura.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String nome;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Topico> topicos;

    @Deprecated
    protected Autor(){
        //Obrigatorio JPA
    }


    public Autor(@Nonnull Long id, @Nonnull String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) && Objects.equals(nome, autor.nome) && Objects.equals(topicos, autor.topicos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, topicos);
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", topicos=" + topicos +
                '}';
    }
}
