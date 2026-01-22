package com.cinedigital.cine_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinedigital.cine_backend.domain.Pelicula;
import com.cinedigital.cine_backend.service.PeliculaService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cine/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    // Inyección de Dependencias
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    // Métodos
    @GetMapping
    public ResponseEntity<List<Pelicula>> listarTodas() {
        return ResponseEntity.ok(peliculaService.listarPeliculas()); // Devuelve todas las películas
    }

    @GetMapping("/cartelera")
    public ResponseEntity<List<Pelicula>> listarEnCartelera() {
        return ResponseEntity.ok(peliculaService.listarPeliculasCartelera());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPorId(@PathVariable String id) {
        return peliculaService.buscarPeliculaPorId(id).map(
                pelicula -> ResponseEntity.ok(pelicula)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pelicula> guardar(@RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = peliculaService.guardar(pelicula);
        return new ResponseEntity<>(nuevaPelicula, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        peliculaService.eliminar(id);
        return ResponseEntity.noContent().build(); // Status 204, no content.
    }
}
