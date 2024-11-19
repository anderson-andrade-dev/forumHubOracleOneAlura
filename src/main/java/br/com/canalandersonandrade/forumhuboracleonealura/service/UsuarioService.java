package br.com.canalandersonandrade.forumhuboracleonealura.service;

import br.com.canalandersonandrade.forumhuboracleonealura.entity.Perfil;
import br.com.canalandersonandrade.forumhuboracleonealura.entity.Usuario;
import br.com.canalandersonandrade.forumhuboracleonealura.enums.Nivel;
import br.com.canalandersonandrade.forumhuboracleonealura.records.DadosUsuario;
import br.com.canalandersonandrade.forumhuboracleonealura.records.DadosUsuarioCadastrado;
import br.com.canalandersonandrade.forumhuboracleonealura.records.PerfilRecord;
import br.com.canalandersonandrade.forumhuboracleonealura.repository.PerfilRepository;
import br.com.canalandersonandrade.forumhuboracleonealura.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Andrade Dev
 * @Data de Criação 18/11/2024
 */
@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PerfilRepository perfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
    }


    public DadosUsuarioCadastrado cadastrar(DadosUsuario dadosUsuario) {
        List<Perfil> perfis = dadosUsuario.perfils()
                .stream()
                .map(p -> perfilRepository.findByNomeEqualsIgnoreCase(p.nome())
                        .orElse(new Perfil(p.nome(), Nivel.buscaPorValor(p.nivel()))))
                .toList();

        perfilRepository.saveAll(perfis);

        var usuario = new Usuario(dadosUsuario.nome(), dadosUsuario.email(), dadosUsuario.senha(), perfis);

        usuario = usuarioRepository.save(usuario);

        return new DadosUsuarioCadastrado(usuario.getId(), usuario.getNome(), usuario.getEmail());


    }

}
