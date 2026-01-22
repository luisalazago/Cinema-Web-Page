package com.cinedigital.cine_backend.service;

import java.util.List;
import java.util.Optional;

import com.cinedigital.cine_backend.domain.Usuario;

public interface UsuarioService {
    Usuario guardar(Usuario usuario);

    List<Usuario> listarUsuarios();

    Optional<Usuario> buscarUsuarioPorId(String id);

    Optional<Usuario> buscarUsuarioPorCorreo(String correo);

    void eliminar(String id);
}
