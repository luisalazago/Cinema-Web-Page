package com.cinedigital.cine_backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.cinedigital.cine_backend.domain.Funcion;

public interface FuncionService {
    Funcion guardar(Funcion funcion);

    List<Funcion> listarFunciones();

    List<Funcion> listarFuncionesPorPelicula(String idPelicula);

    List<Funcion> listarFuncionesPorFecha(LocalDate fecha);

    Optional<Funcion> buscarFuncionPorId(String id);

    void eliminar(String id);
}
