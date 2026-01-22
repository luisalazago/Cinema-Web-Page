package com.cinedigital.cine_backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinedigital.cine_backend.domain.Pelicula;
import com.cinedigital.cine_backend.repository.PeliculaRepository;
import com.cinedigital.cine_backend.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    private final PeliculaRepository peliculaRepository;

    // Inyección de Dependencias
    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    // Implementación Métodos
    @Override
    @Transactional
    public Pelicula guardar(Pelicula pelicula) {
        if (pelicula.getId() == null || pelicula.getId().isEmpty()) {
            pelicula.setId(UUID.randomUUID().toString()); // Se genera un único id.
        }

        return peliculaRepository.save(pelicula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> listarPeliculasCartelera() {
        return peliculaRepository.findByCarteleraTrue();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pelicula> buscarPeliculaPorId(String id) {
        return peliculaRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(String id) {
        peliculaRepository.deleteById(id);
    }
}
