package com.cinedigital.cine_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinedigital.cine_backend.domain.Compras;
import com.cinedigital.cine_backend.service.CompraService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cine/compras")
public class ComprasController {
    private final CompraService compraService;

    // Inyección de Dependencias
    public ComprasController(CompraService compraService) {
        this.compraService = compraService;
    }

    // Métodos
    @PostMapping
    public ResponseEntity<?> comprar(@RequestBody Compras compras) {
        Compras nuevaCompra = null;
        try {
            nuevaCompra = compraService.registrarCompra(compras);
            return new ResponseEntity<>(nuevaCompra, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Compras>> historialComprasUsuario(@PathVariable String idUsuario) {
        return ResponseEntity.ok(compraService.listarComprasPorUsuario(idUsuario));
    }
}
