package com.cinedigital.cine_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinedigital.cine_backend.domain.Compras;

public interface ComprasRepository extends JpaRepository<Compras, String> {
    List<Compras> findByUsuarioId(String usuarioId); // Buscar historial de compras de un usuario.
}
