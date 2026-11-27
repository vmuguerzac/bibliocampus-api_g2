package com.vmuguerzac.bibliocampus_api.pruebas_unitarias;

import com.vmuguerzac.bibliocampus_api.servicios.LibroServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vmuguerzac.bibliocampus_api.modelo.Libro;
import com.vmuguerzac.bibliocampus_api.repositorio.LibroRepositorio;

@Component 
public class DatosPrueba implements CommandLineRunner {
    private final LibroServicio libroServicio;
    private final LibroRepositorio libroRepositorio;

    public DatosPrueba(LibroRepositorio instancia, LibroServicio libroServicio){
        this.libroRepositorio = instancia;
        this.libroServicio = libroServicio;
    }

    @Override
    public void run(String... args) throws Exception {
        if(libroRepositorio.count() == 0){
            System.out.println("###### Inicia la prueba de guardar");
            libroRepositorio.save(new Libro(null, "Effective Java", "Joshua Bloch", "Java", 2018, "", 5));
            libroRepositorio.save(new Libro(null, "Spring in Action", "Craig Walls", "Spring", 2022, "", 0));
            libroRepositorio.save(new Libro(null, "Design Patterns", "Gamma, Helm, Johnson, Vlissides", "Patrones de diseño", 1994, "", 2));
            libroRepositorio.save(new Libro(null, "Refactoring", "Martin Fowler", "Buenas prácticas", 2018, "", 0));
            libroRepositorio.save(new Libro(null, "The Pragmatic Programmer", "Hunt y Thomas", "Buenas prácticas", 2019, "", 4));
            System.out.println("###### Finaliza la prueba de guardar");
        }
    }
    
}
