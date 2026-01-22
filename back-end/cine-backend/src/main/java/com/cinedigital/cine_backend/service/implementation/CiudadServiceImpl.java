package com.cinedigital.cine_backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinedigital.cine_backend.domain.Ciudad;
import com.cinedigital.cine_backend.repository.CiudadRepository;
import com.cinedigital.cine_backend.service.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService {
    private final CiudadRepository ciudadRepository;

    // Inyección de Dependencias.
    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    // Implementación Métodos
    @Override
    @Transactional
    public Ciudad guardar(Ciudad ciudad) {
        if (ciudad.getId() == null || ciudad.getId().isEmpty()) {
            ciudad.setId(UUID.randomUUID().toString());
        }

        return ciudadRepository.save(ciudad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ciudad> listarCiudades() {
        return ciudadRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ciudad> buscarCiudadPorId(String id) {
        return ciudadRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(String id) {
        ciudadRepository.deleteById(id);
    }
}
