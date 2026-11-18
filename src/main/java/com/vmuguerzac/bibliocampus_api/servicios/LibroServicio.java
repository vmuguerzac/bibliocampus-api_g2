package com.vmuguerzac.bibliocampus_api.servicios;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vmuguerzac.bibliocampus_api.modelo.Libro;
import com.vmuguerzac.bibliocampus_api.repositorio.LibroRepositorio;

@Service 
public class LibroServicio {
    private LibroRepositorio libroRepositorio;

    public LibroServicio(LibroRepositorio instancia){
        this.libroRepositorio = instancia;
    }

    // ListarLibros
    public List<Libro> listarLibros(){
        return libroRepositorio.findAll(); // SELECT .... FROM LIBROS;
    }
    // BuscarPorId
    // Regla de Negocio: Si el libro no existe lanzar un 404 (NOT FOUND)
    public Libro obtenerPorId(Long id){
        return libroRepositorio.findById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El libro no existe"));
    }
}
