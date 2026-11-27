package com.vmuguerzac.bibliocampus_api.servicios;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vmuguerzac.bibliocampus_api.dto.LibroSolicitud;
import com.vmuguerzac.bibliocampus_api.modelo.Libro;
import com.vmuguerzac.bibliocampus_api.repositorio.LibroRepositorio;

@Service 
public class LibroServicio {
    private LibroRepositorio libroRepositorio;

    public LibroServicio(LibroRepositorio instancia){
        this.libroRepositorio = instancia;
    }

    public Libro crearLibro(LibroSolicitud datosLibro){
        Libro libro = new Libro();
        copiarDatos(datosLibro, libro);
        return libroRepositorio.save(libro); // INSERT (el libro)
    }

    public void copiarDatos(LibroSolicitud datosLibro, Libro libro){
        libro.setTitulo(datosLibro.titulo().trim());
        libro.setAutor(datosLibro.autor().trim());
        libro.setCategoria(datosLibro.categoria().trim());
        libro.setAnio(datosLibro.anio());
        libro.setPortadaUrl(datosLibro.portadaUrl() == null ? "" : datosLibro.portadaUrl());
        libro.setCopiasDisponibles(datosLibro.copiasDisponibles());
    }

    public List<Libro> listarLibros(String q, List<String> categorias, boolean soloDisponible, String orden){
        return libroRepositorio.buscarLibro(q, categorias, soloDisponible, orden);
    }
    
    // BuscarPorId
    // Regla de Negocio: Si el libro no existe lanzar un 404 (NOT FOUND)
    public Libro obtenerPorId(Long id){
        return libroRepositorio.findById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El libro no existe"));
    }

    public List<String> obtenerCategorias(){
        return libroRepositorio.obtenerCategorias();
    }
}
