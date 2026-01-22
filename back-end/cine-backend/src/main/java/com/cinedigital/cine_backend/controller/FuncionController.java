package com.cinedigital.cine_backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinedigital.cine_backend.domain.Funcion;
import com.cinedigital.cine_backend.service.FuncionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cine/funciones")
public class FuncionController {
    private final FuncionService funcionService;

    public FuncionController(FuncionService funcionService) {
        this.funcionService = funcionService;
    }

    @GetMapping
    public ResponseEntity<List<Funcion>> listarFunciones() {
        return ResponseEntity.ok(funcionService.listarFunciones());
    }

    @GetMapping("/pelicula/{idPelicula}")
    public ResponseEntity<List<Funcion>> listarPorPelicula(@PathVariable String idPelicula) {
        return ResponseEntity.ok(funcionService.listarFuncionesPorPelicula(idPelicula));
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Funcion>> listarPorFecha(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(funcionService.listarFuncionesPorFecha(fecha));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcion> buscarPorId(@PathVariable String id) {
        return funcionService.buscarFuncionPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcion> guardar(@RequestBody Funcion funcion) {
        Funcion nuevaFuncion = funcionService.guardar(funcion);
        return new ResponseEntity<>(nuevaFuncion, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        funcionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
