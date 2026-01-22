package com.cinedigital.cine_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinedigital.cine_backend.domain.Teatro;

public interface TeatroRepository extends JpaRepository<Teatro, String> {
    List<Teatro> findByCiudadId(String ciudadId); // Buscar teatros por ciudad.
}
