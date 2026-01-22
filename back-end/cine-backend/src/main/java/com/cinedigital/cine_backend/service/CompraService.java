package com.cinedigital.cine_backend.service;

import java.util.List;
import java.util.Optional;

import com.cinedigital.cine_backend.domain.Compras;

public interface CompraService {
    Compras registrarCompra(Compras compras);

    List<Compras> listarCompras();

    List<Compras> listarComprasPorUsuario(String idUsuario);

    Optional<Compras> buscarCompraPorId(String id);

    void eliminar(String id);
}
