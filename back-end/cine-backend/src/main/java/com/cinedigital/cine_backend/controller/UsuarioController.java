package com.cinedigital.cine_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinedigital.cine_backend.domain.Usuario;
import com.cinedigital.cine_backend.service.UsuarioService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cine/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    // Inyección de Dependencias
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable String id) {
        return usuarioService.buscarUsuarioPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardar(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }
}
