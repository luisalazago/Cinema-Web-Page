package com.cinedigital.cine_backend.service;

import java.util.List;
import java.util.Optional;

import com.cinedigital.cine_backend.domain.Pelicula;

public interface PeliculaService {
    Pelicula guardar(Pelicula pelicula);

    List<Pelicula> listarPeliculas(); // Obtiene todas las películas.

    List<Pelicula> listarPeliculasCartelera(); // Obtiene todas las películas que estén en cartelera.

    Optional<Pelicula> buscarPeliculaPorId(String id);

    void eliminar(String id);
}
