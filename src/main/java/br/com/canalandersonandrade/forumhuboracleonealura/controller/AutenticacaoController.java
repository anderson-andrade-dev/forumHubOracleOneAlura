package br.com.canalandersonandrade.forumhuboracleonealura.controller;

import br.com.canalandersonandrade.forumhuboracleonealura.configuracao.seguranca.TokenService;
import br.com.canalandersonandrade.forumhuboracleonealura.configuracao.seguranca.record.DadosAutenticacao;
import br.com.canalandersonandrade.forumhuboracleonealura.configuracao.seguranca.record.DadosTokenJWT;
import br.com.canalandersonandrade.forumhuboracleonealura.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 27/11/2024
 */

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var tokenAutenticado = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var autenticacao = manager.authenticate(tokenAutenticado);

        var tokenJWT = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
