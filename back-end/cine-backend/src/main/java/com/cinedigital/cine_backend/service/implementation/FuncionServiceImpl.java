package com.cinedigital.cine_backend.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinedigital.cine_backend.domain.Funcion;
import com.cinedigital.cine_backend.repository.FuncionRepository;
import com.cinedigital.cine_backend.service.FuncionService;

@Service
public class FuncionServiceImpl implements FuncionService {
    private final FuncionRepository funcionRepository;

    // Inyección de Dependencias
    public FuncionServiceImpl(FuncionRepository funcionRepository) {
        this.funcionRepository = funcionRepository;
    }

    // Implementación Métodos
    @Override
    @Transactional
    public Funcion guardar(Funcion funcion) {
        if (funcion.getId() == null || funcion.getId().isEmpty()) {
            funcion.setId(UUID.randomUUID().toString());
        }

        return funcionRepository.save(funcion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcion> listarFunciones() {
        return funcionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcion> listarFuncionesPorPelicula(String idPelicula) {
        return funcionRepository.findByPeliculaId(idPelicula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcion> listarFuncionesPorFecha(LocalDate fecha) {
        return funcionRepository.findByFecha(fecha);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Funcion> buscarFuncionPorId(String id) {
        return funcionRepository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(String id) {
        funcionRepository.deleteById(id);
    }
}
