package br.com.canalandersonandrade.forumhuboracleonealura.controller;

import br.com.canalandersonandrade.forumhuboracleonealura.entity.Topico;
import br.com.canalandersonandrade.forumhuboracleonealura.records.DadosRetornoTopico;
import br.com.canalandersonandrade.forumhuboracleonealura.records.DadosTopico;
import br.com.canalandersonandrade.forumhuboracleonealura.service.TopicoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */

@RestController
@RequestMapping("forum")
public class ForumController {

    private final TopicoService topicoService;

    public ForumController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping("/topicos")
    public ResponseEntity criarTopico(@RequestBody @NotNull DadosTopico dadosTopico) {
        var topico = topicoService.salvar(dadosTopico).orElseThrow(() -> new RuntimeException("Erro ao cadastrar o topico!"));

        return ResponseEntity.ok(topico);
    }

    @GetMapping("/topicos")
    public ResponseEntity todoTopicosCriados() {
      return ResponseEntity.ok(topicoService.todosTopicos());
    }

    public void buscarTopico() {

    }

    public void atualizarTopico() {

    }

}

/*
Listagem de tópicos
A API deve possuir um endpoint para a listagem de todos os tópicos, sendo que ele deve aceitar requisições do tipo GET para a URI /topicos

Os dados dos tópicos (título, mensagem, data de criação, status, autor e curso) devem ser devolvidos no corpo da resposta, no formato JSON.

→ Lembrando que ao tratar do CRUD é necessário trabalhar com o JpaRepository associado ao tópico, em especial na listagem dos dados do banco de dados utilizamos o método findAll.

Opcionais:

Que tal exibir os 10 primeiros resultados ordenados pela data de criação do tópico em ordem ASC?

Que tal mostrar os resultados usando um critério de busca? Sugerimos listar por: nome de curso e ano específico.

Mais um opcional: Que tal praticar a listagem dos resultados com paginação? Utilizando a anotação@PageableDefault em seu código para manejar o volume de dados apresentados para o usuário.
 */