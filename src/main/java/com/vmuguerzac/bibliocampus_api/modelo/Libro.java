package com.vmuguerzac.bibliocampus_api.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "libros")
public class Libro {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    @Column(nullable = false, length = 150) 
    private String titulo;
    @Column(nullable = false, length = 120) 
    private String autor;
    @Column(nullable = false, length = 60) 
    private String categoria;
    private int anio;
    @Column(length = 500) 
    private String portadaUrl;
    private int copiasDisponibles;

    public Libro(){

    }
    
    public Libro(Long id, String titulo, String autor, String categoria, int anio, String portadaUrl,
            int copiasDisponibles) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.anio = anio;
        this.portadaUrl = portadaUrl;
        this.copiasDisponibles = copiasDisponibles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPortadaUrl() {
        return portadaUrl;
    }

    public void setPortadaUrl(String portadaUrl) {
        this.portadaUrl = portadaUrl;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }
    
}
