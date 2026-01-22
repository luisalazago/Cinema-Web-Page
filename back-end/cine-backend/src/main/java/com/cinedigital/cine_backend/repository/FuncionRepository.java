package com.cinedigital.cine_backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinedigital.cine_backend.domain.Funcion;

public interface FuncionRepository extends JpaRepository<Funcion, String> {
    List<Funcion> findByPeliculaId(String peliculaId); // Buscar película por id de la BD.

    List<Funcion> findByFecha(LocalDate fecha); // Buscar funciones por fecha específica.
}
