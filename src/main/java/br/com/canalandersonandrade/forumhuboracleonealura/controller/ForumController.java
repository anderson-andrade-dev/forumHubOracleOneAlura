package br.com.canalandersonandrade.forumhuboracleonealura.controller;

import br.com.canalandersonandrade.forumhuboracleonealura.records.DadosAtualizacao;
import br.com.canalandersonandrade.forumhuboracleonealura.records.DadosRetornoTopico;
import br.com.canalandersonandrade.forumhuboracleonealura.records.DadosTopico;
import br.com.canalandersonandrade.forumhuboracleonealura.service.TopicoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/topicos/{id}")
    public ResponseEntity buscarTopico(@PathVariable @Valid Long id) {
        DadosRetornoTopico topico = topicoService.buscaPorId(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/topicos/{id}")
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody DadosAtualizacao dadosAtualizacao) {

        var dadosTopicoRetorno = topicoService.atualizar(id, dadosAtualizacao);

        return ResponseEntity.ok(dadosTopicoRetorno);
    }

    @DeleteMapping("/topicos/{id}")
    public ResponseEntity deletarTopico(@PathVariable Long id){

        topicoService.deletar(id);

        return ResponseEntity.ok("Topico deletado com sucesso!");
    }

/*
Exclusão de tópico
A API deve possuir um endpoint para a exclusão de um determinado tópico, sendo que ele deve aceitar requisições do tipo DELETE para a URI /topicos/{id}.

Como estamos realizando uma consulta no banco para então atualizar um tópico, é necessário solicitar e verificar o campo ID de sua requisição.

No código do projeto, sugerimos como no card de Detalhamento de Tópicos o uso da anotação @PathVariable para obter o ID da requisição PUT.

→ Lembre-se de verificar se o tópico existe no banco de dados para realizar sua atualização. Neste caso, sugerimos a utilização do método isPresent() da classe Java chamada Optional.

Por fim, por se tratar de uma exclusão de um item específico do banco, vale ressaltar a importância do uso do método deleteById do JpaRepository.
 */


}
