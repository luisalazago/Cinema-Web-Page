package com.cinedigital.cine_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario") // Nombre de la tabla en la base de datos.
public class Usuario {
    @Id
    @Column(length = 100)
    private String id;

    @Column(nullable = false, length = 500)
    private String nombres;

    @Column(nullable = false, length = 500)
    private String correo;

    @Column(nullable = false, length = 100)
    private String celular;

    @Column(nullable = false, length = 500)
    private String password;

    private Boolean activo;

    @Column(name = "tipo_usuario", length = 100)
    private String tipoUsuario;

    // Constructor
    public Usuario() {
    }

    // Métodos Set
    public void setId(String id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    // Métodos Get
    public String getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCelular() {
        return celular;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}
