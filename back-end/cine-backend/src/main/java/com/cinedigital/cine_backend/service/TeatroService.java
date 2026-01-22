package com.cinedigital.cine_backend.service;

import java.util.List;
import java.util.Optional;

import com.cinedigital.cine_backend.domain.Teatro;

public interface TeatroService {
    Teatro guardar(Teatro teatro);

    List<Teatro> listarTeatros();

    List<Teatro> listarTeatrosPorCiudad(String idCiudad);

    Optional<Teatro> buscarTeatroPorId(String id);

    void eliminar(String id);
}
