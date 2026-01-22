package com.cinedigital.cine_backend.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Funcion") // Nombre de la tabla en la base de datos.
public class Funcion {
    @Id
    @Column(length = 100)
    private String id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(name = "sillas_disponibles", nullable = false)
    private Integer sillasDisponibles;

    // Relación: Una o muchas películas tienen asociada una misma función.
    @ManyToOne
    @JoinColumn(name = "id_pelicula", nullable = false)
    private Pelicula pelicula;

    // Relación: Uno o muchos teatros tinen asociado una misma función.
    @ManyToOne
    @JoinColumn(name = "id_teatro", nullable = false)
    private Teatro teatro;

    // Constructor
    public Funcion() {
    }

    // Métodos Set
    public void setId(String id) {
        this.id = id;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setSillasDisponibles(Integer sillasDisponibles) {
        this.sillasDisponibles = sillasDisponibles;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }

    // Métodos Get
    public String getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public Integer getSillasDisponibles() {
        return sillasDisponibles;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Teatro getTeatro() {
        return teatro;
    }
}
