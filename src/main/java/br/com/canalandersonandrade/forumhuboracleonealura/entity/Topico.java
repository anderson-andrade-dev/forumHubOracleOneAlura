package br.com.canalandersonandrade.forumhuboracleonealura.entity;

import br.com.canalandersonandrade.forumhuboracleonealura.records.TopicoRecord;
import br.com.canalandersonandrade.forumhuboracleonealura.uteis.DataUtil;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
@Entity
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String titulo;
    @Column(nullable = false, length = 1000)
    private String mensagem;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dataCriacao;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @OneToOne
    private Curso curso;
    @OneToMany(mappedBy = "topico", fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Resposta> respostas;

    @Deprecated
    protected Topico() {
        //Uso Obrigatorio JPA
    }

    public Topico(String titulo, String mensagem, LocalDateTime dataCriacao, boolean status, Autor autor, Curso curso, List<Resposta> respostas) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.respostas = respostas;
    }

    public Topico(TopicoRecord topicoRecord) {
        this.titulo = topicoRecord.titulo();
        this.mensagem = topicoRecord.mensagem();
        this.dataCriacao = DataUtil.converter(topicoRecord.dataCriacao());
        this.status = topicoRecord.status();
        this.autor = new Autor(topicoRecord.autor().id(), topicoRecord.autor().nome());
        this.curso = new Curso(topicoRecord.curso().id(), topicoRecord.curso().nome(), topicoRecord.curso().categoria());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topico topico = (Topico) o;
        return status == topico.status && Objects.equals(id, topico.id) && Objects.equals(titulo, topico.titulo) && Objects.equals(mensagem, topico.mensagem) && Objects.equals(dataCriacao, topico.dataCriacao) && Objects.equals(autor, topico.autor) && Objects.equals(curso, topico.curso) && Objects.equals(respostas, topico.respostas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, mensagem, dataCriacao, status, autor, curso, respostas);
    }

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", status=" + status +
                ", autor=" + autor +
                ", curso=" + curso +
                ", respostas=" + respostas +
                '}';
    }
}
