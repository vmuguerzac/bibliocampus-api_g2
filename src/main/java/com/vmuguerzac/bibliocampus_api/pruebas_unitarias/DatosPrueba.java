package com.vmuguerzac.bibliocampus_api.pruebas_unitarias;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vmuguerzac.bibliocampus_api.modelo.Libro;
import com.vmuguerzac.bibliocampus_api.repositorio.LibroRepositorio;

@Component 
public class DatosPrueba implements CommandLineRunner {
    private final LibroRepositorio libroRepositorio;

    public DatosPrueba(LibroRepositorio instancia){
        this.libroRepositorio = instancia;
    }

    @Override
    public void run(String... args) throws Exception {
        // System.out.println("###### Inicia la prueba de guardar");
        // Libro libro = new Libro(
        //     null, 
        //     "Clean Code", 
        //     "Robert C. Martin", 
        //     "Buenas prácticas", 
        //     2008, 
        //     "", 
        //     3);
        // libroRepositorio.save(libro);
        // System.out.println("###### Finaliza la prueba de guardar");
    }
    
}
