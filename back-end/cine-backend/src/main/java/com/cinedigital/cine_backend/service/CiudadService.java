package com.cinedigital.cine_backend.service;

import java.util.List;
import java.util.Optional;

import com.cinedigital.cine_backend.domain.Ciudad;

public interface CiudadService {
    Ciudad guardar(Ciudad ciudad);

    List<Ciudad> listarCiudades();

    Optional<Ciudad> buscarCiudadPorId(String id);

    void eliminar(String id);
}
