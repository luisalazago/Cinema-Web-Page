package com.cinedigital.cine_backend.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Compras") // Nombre de la tabla en la base de datos.
public class Compras {
    @Id
    @Column(length = 100)
    private String id;

    @Column(name = "cantidad_entradas", nullable = false)
    private Integer cantidadEntradas;

    @Column(name = "precio_total", nullable = false)
    private BigDecimal precioTotal;

    @Column(name = "fecha_compra", nullable = false)
    private LocalDate fechaCompra;

    @Column(name = "metodo_pago", nullable = false, length = 100)
    private String metodoPago;

    @Column(name = "info_pago", length = 2000)
    private String infoPago;

    // Relación: Muchas compras pertenecen a un usuario.
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    // Relación: Muchas compras pertenecen a una función.
    @ManyToOne
    @JoinColumn(name = "id_funcion", nullable = false)
    private Funcion funcion;

    // Constructor
    public Compras() {
    }

    // Métodos Set
    public void setId(String id) {
        this.id = id;
    }

    public void setCantidadEntradas(Integer cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setInfoPago(String infoPago) {
        this.infoPago = infoPago;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    // Métodos Get
    public String getId() {
        return id;
    }

    public Integer getCantidadEntradas() {
        return cantidadEntradas;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getInfoPago() {
        return infoPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Funcion getFuncion() {
        return funcion;
    }
}
