package com.vmuguerzac.bibliocampus_api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmuguerzac.bibliocampus_api.modelo.Libro;

public interface LibroRepositorio extends JpaRepository<Libro, Long>{
    // Genera automaticamente los metodos
    // save, findById, findAll, count, existsById, deleteById

}
