package com.vmuguerzac.bibliocampus_api.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmuguerzac.bibliocampus_api.modelo.Libro;
import com.vmuguerzac.bibliocampus_api.servicios.LibroServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController 
@RequestMapping("/api/libros")
@CrossOrigin(origins = "http://localhost:4200")
public class LibroControlador {
    private final LibroServicio libroServicio;

    public LibroControlador(LibroServicio instancia){
        this.libroServicio = instancia;
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return libroServicio.listarLibros();
    }

    @GetMapping("/{id}")
    public Libro obtenerPorId(@PathVariable("id") Long id) {
        return libroServicio.obtenerPorId(id);
    }
    
    
    
}
