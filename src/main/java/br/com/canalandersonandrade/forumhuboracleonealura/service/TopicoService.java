package br.com.canalandersonandrade.forumhuboracleonealura.service;

import br.com.canalandersonandrade.forumhuboracleonealura.entity.Autor;
import br.com.canalandersonandrade.forumhuboracleonealura.entity.Curso;
import br.com.canalandersonandrade.forumhuboracleonealura.entity.Topico;
import br.com.canalandersonandrade.forumhuboracleonealura.enums.Categoria;
import br.com.canalandersonandrade.forumhuboracleonealura.records.DadosTopico;
import br.com.canalandersonandrade.forumhuboracleonealura.repository.AutorRepository;
import br.com.canalandersonandrade.forumhuboracleonealura.repository.CursoRepository;
import br.com.canalandersonandrade.forumhuboracleonealura.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.net.CacheRequest;
import java.util.List;
import java.util.Optional;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 19/11/2024
 */
@Service
public class TopicoService {
    private final TopicoRepository topicoRepository;
    private final AutorRepository autorRepository;
    private final CursoRepository cursoRepository;

    public TopicoService(TopicoRepository topicoRepository, AutorRepository autorRepository,CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.autorRepository = autorRepository;
        this.cursoRepository = cursoRepository;
    }

    public Optional<Topico> salvar(DadosTopico dadosTopico) {
        Autor autor = new Autor(dadosTopico.autor());
        autorRepository.save(autor);
        Curso curso = new Curso(dadosTopico.curso(),Categoria.PROGRAMACAO);
        cursoRepository.save(curso);
        Topico topico = new Topico(dadosTopico.titulo(), dadosTopico.mensagem(), autor, curso);
        topicoRepository.save(topico);
        return Optional.of(topico);
    }

    public List<Topico> todosTopicos() {
        var topicos = topicoRepository.findAll();
        if(topicos != null){
            return topicos;
        }
        return List.of();
    }
}
