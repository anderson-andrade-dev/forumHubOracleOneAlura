package br.com.canalandersonandrade.forumhuboracleonealura.controller;

import br.com.canalandersonandrade.forumhuboracleonealura.records.DadosUsuario;
import br.com.canalandersonandrade.forumhuboracleonealura.service.UsuarioService;
import jakarta.annotation.Nonnull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
@RestController
@RequestMapping("/cadastro")
public class CadastroController {
  private UsuarioService usuarioService;

    public CadastroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Nonnull DadosUsuario dadosUsuario){
      System.out.println(dadosUsuario.nome());
      System.out.println(dadosUsuario.email());
      return ResponseEntity.ok(usuarioService.cadastrar(dadosUsuario));
    }

    public void alterar(){

    }

    public void remover(){

    }
}
