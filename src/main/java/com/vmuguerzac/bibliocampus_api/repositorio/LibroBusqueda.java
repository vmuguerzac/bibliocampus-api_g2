package com.vmuguerzac.bibliocampus_api.repositorio;

import java.util.List;

import com.vmuguerzac.bibliocampus_api.modelo.Libro;

public interface LibroBusqueda {
    List<Libro> buscarLibro(String q, List<String> categorias, boolean soloDisponibles, String orden);
    
}
