package com.vmuguerzac.bibliocampus_api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vmuguerzac.bibliocampus_api.modelo.Libro;

public interface LibroRepositorio extends JpaRepository<Libro, Long>, LibroBusqueda{
    // Genera automaticamente los metodos
    // save, findById, findAll, count, existsById, deleteById
    List<Libro> findAllByOrderByTituloAsc();
    List<Libro> findTop3ByOrderByCopiasDisponiblesDesc();

    @Query("SELECT DISTINCT l.categoria FROM Libro l ORDER BY l.categoria")
    List<String> obtenerCategorias();
}
