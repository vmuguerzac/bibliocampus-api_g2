package com.vmuguerzac.bibliocampus_api.dto;

import java.time.LocalDate;

import com.vmuguerzac.bibliocampus_api.modelo.EstadoPrestamo;
import com.vmuguerzac.bibliocampus_api.modelo.Libro;
import com.vmuguerzac.bibliocampus_api.modelo.Prestamo;

public record PrestamoRespuesta(Long id, Long libroId, Long usuarioId, LocalDate fecha, 
    EstadoPrestamo estado, Libro libro) {
        public static PrestamoRespuesta de(Prestamo p){
            return new PrestamoRespuesta(
                p.getId(), 
                p.getLibro().getId(), 
                p.getUsuarioId(), 
                p.getFecha(), 
                p.getEstado(), 
                p.getLibro());
        }
    }