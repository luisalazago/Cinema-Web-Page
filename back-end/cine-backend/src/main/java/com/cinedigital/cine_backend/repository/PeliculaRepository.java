package com.cinedigital.cine_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinedigital.cine_backend.domain.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, String> {
    List<Pelicula> findByCarteleraTrue(); // Busca las películas que estén en cartelera (true).
}
