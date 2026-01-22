package com.cinedigital.cine_backend.service.implementation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinedigital.cine_backend.domain.Compras;
import com.cinedigital.cine_backend.domain.Funcion;
import com.cinedigital.cine_backend.repository.ComprasRepository;
import com.cinedigital.cine_backend.repository.FuncionRepository;
import com.cinedigital.cine_backend.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {
    private final ComprasRepository comprasRepository;
    private final FuncionRepository funcionRepository;

    // Inyección de Dependencias
    public CompraServiceImpl(ComprasRepository comprasRepository, FuncionRepository funcionRepository) {
        this.comprasRepository = comprasRepository;
        this.funcionRepository = funcionRepository;
    }

    // Implementación Métodos
    @Override
    @Transactional
    public Compras registrarCompra(Compras compras) {
        Funcion funcion = funcionRepository.findById(compras.getFuncion().getId())
                .orElseThrow(() -> new RuntimeException("La función no existe."));
        BigDecimal total;

        if (funcion.getSillasDisponibles() < compras.getCantidadEntradas()) {
            throw new RuntimeException("No hay suficientes sillas disponibles.");
        }

        funcion.setSillasDisponibles(funcion.getSillasDisponibles() - compras.getCantidadEntradas());
        funcionRepository.save(funcion);

        total = funcion.getPrecio().multiply(new BigDecimal(compras.getCantidadEntradas()));
        compras.setPrecioTotal(total);

        compras.setFechaCompra(LocalDate.now());

        if (compras.getId() == null || compras.getId().isEmpty()) {
            compras.setId(UUID.randomUUID().toString());
        }

        return comprasRepository.save(compras);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Compras> listarCompras() {
        return comprasRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Compras> listarComprasPorUsuario(String idUsuario) {
        return comprasRepository.findByUsuarioId(idUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Compras> buscarCompraPorId(String id) {
        return comprasRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(String id) {
        comprasRepository.deleteById(id);
    }
}
