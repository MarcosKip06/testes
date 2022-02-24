package com.desafioapi.controllers;

import com.desafioapi.models.Usuario;
import com.desafioapi.repositories.UsuarioRepository;
import com.desafioapi.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
        usuario = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }
}
