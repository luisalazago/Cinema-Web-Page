package com.cinedigital.cine_backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinedigital.cine_backend.domain.Teatro;
import com.cinedigital.cine_backend.repository.TeatroRepository;
import com.cinedigital.cine_backend.service.TeatroService;

@Service
public class TeatroServiceImpl implements TeatroService {
    private final TeatroRepository teatroRepository;

    // Inyección de Dependencias.
    public TeatroServiceImpl(TeatroRepository teatroRepository) {
        this.teatroRepository = teatroRepository;
    }

    // Implementación Métodos
    @Override
    @Transactional
    public Teatro guardar(Teatro teatro) {
        if (teatro.getId() == null || teatro.getId().isEmpty()) {
            teatro.setId(UUID.randomUUID().toString());
        }

        return teatroRepository.save(teatro);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Teatro> listarTeatros() {
        return teatroRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Teatro> listarTeatrosPorCiudad(String idCiudad) {
        return teatroRepository.findByCiudadId(idCiudad);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Teatro> buscarTeatroPorId(String id) {
        return teatroRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(String id) {
        teatroRepository.deleteById(id);
    }
}
