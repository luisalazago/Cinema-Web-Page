package com.cinedigital.cine_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinedigital.cine_backend.domain.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, String> {

}
