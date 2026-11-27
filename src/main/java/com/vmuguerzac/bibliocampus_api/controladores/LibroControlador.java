package com.vmuguerzac.bibliocampus_api.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmuguerzac.bibliocampus_api.dto.LibroSolicitud;
import com.vmuguerzac.bibliocampus_api.modelo.Libro;
import com.vmuguerzac.bibliocampus_api.servicios.LibroServicio;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping("/api/libros")
public class LibroControlador {
    private final LibroServicio libroServicio;

    public LibroControlador(LibroServicio instancia){
        this.libroServicio = instancia;
    }

    // POST
    @PostMapping
    public ResponseEntity<Libro> crearLibro(@Valid @RequestBody LibroSolicitud datosLibro) {
        Libro creado = libroServicio.crearLibro(datosLibro);
        URI ubicacion = URI.create("/api/libros/" + creado.getId());
        return ResponseEntity.created(ubicacion).body(creado); // 201 Created + Location
    }
    

    @GetMapping("/{id}")
    public Libro obtenerPorId(@PathVariable("id") Long id) {
        return libroServicio.obtenerPorId(id);
    }

    // GET listarLibros
    @GetMapping
    public List<Libro> listarLibros(
            @RequestParam(name="q", required = false) String q,
            @RequestParam(name="categoria", required = false) List<String> categoria,
            @RequestParam(name="soloDisponibles", defaultValue = "false") boolean soloDisponibles,
            @RequestParam(name="orden", defaultValue = "titulo") String orden)
    {
        return libroServicio.listarLibros(q, categoria, soloDisponibles, orden);
    }

    @GetMapping("/categorias")
    public List<String> obtenerCategorias() {
        return libroServicio.obtenerCategorias();
    }
    
}
