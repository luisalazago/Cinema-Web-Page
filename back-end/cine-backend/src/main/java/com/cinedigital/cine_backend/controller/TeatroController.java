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

import com.cinedigital.cine_backend.domain.Teatro;
import com.cinedigital.cine_backend.service.TeatroService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cine/teatros")
public class TeatroController {
    private final TeatroService teatroService;

    // Inyección de Dependencias
    public TeatroController(TeatroService teatroService) {
        this.teatroService = teatroService;
    }

    // Métodos
    @GetMapping
    public ResponseEntity<List<Teatro>> listarTeatros() {
        return ResponseEntity.ok(teatroService.listarTeatros());
    }

    @GetMapping("/ciudad/{idCiudad}")
    public ResponseEntity<List<Teatro>> listarPorCiudad(@PathVariable String idCiudad) {
        List<Teatro> teatros = teatroService.listarTeatrosPorCiudad(idCiudad);
        return ResponseEntity.ok(teatros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teatro> buscarPorId(@PathVariable String id) {
        return teatroService.buscarTeatroPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Teatro> guardar(@RequestBody Teatro teatro) {
        Teatro nuevoTeatro = teatroService.guardar(teatro);
        return new ResponseEntity<>(nuevoTeatro, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        teatroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
