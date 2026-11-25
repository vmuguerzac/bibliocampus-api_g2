package com.vmuguerzac.bibliocampus_api.servicios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.vmuguerzac.bibliocampus_api.dto.PrestamoRespuesta;
import com.vmuguerzac.bibliocampus_api.modelo.EstadoPrestamo;
import com.vmuguerzac.bibliocampus_api.modelo.Libro;
import com.vmuguerzac.bibliocampus_api.modelo.Prestamo;
import com.vmuguerzac.bibliocampus_api.repositorio.LibroRepositorio;
import com.vmuguerzac.bibliocampus_api.repositorio.PrestamoRepositorio;

public class PrestamoServicio {
    private final LibroRepositorio libroRepositorio;
    private final PrestamoRepositorio prestamoRepositorio;

    public PrestamoServicio(LibroRepositorio instanciaLibroRepo, PrestamoRepositorio instanciaPrestamoRepo){
        this.libroRepositorio = instanciaLibroRepo;
        this.prestamoRepositorio = instanciaPrestamoRepo;
    }
    // Reglas Negocio: el libro debe existir (404), 
    // Regla del negocio: debe tener copias (409);
    // se descuenta una copia del libro (actualizacion) y se crea el prestamo (insert)

    // usar syncronized para evitar que las peticiones se realicen en simultaneo
    public synchronized PrestamoRespuesta solitarLibro(Long usuarioId, Long libroId){
        // Regla 1 libro existe
        Libro libro = libroRepositorio.findById(libroId)
                            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no existe"));
        // regla 2 libro tiene copias?
        if(libro.getCopiasDisponibles() <= 0){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "No hay copias Disponibles");
        }
        // actualizar las copias disponibles
        libro.setCopiasDisponibles(libro.getCopiasDisponibles() - 1);
        libroRepositorio.save(libro); // UPDATE libros

        Prestamo prestamo = new Prestamo(libro, usuarioId, LocalDate.now(), EstadoPrestamo.ACTIVO);
        return PrestamoRespuesta.de(prestamoRepositorio.save(prestamo)); // INSERT

    }

    public List<PrestamoRespuesta> listarTodosPrestamos(){
        return prestamoRepositorio.obtenerTodosLosPrestamos().stream().map(PrestamoRespuesta::de).toList();
    }
    
}
