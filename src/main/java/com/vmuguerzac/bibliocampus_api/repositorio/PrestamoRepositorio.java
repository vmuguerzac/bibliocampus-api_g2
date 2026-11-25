package com.vmuguerzac.bibliocampus_api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vmuguerzac.bibliocampus_api.modelo.Prestamo;

public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long> {
    @Query("SELECT p FROM Prestamo p "
        + "JOIN FETCH p.libro WHERE p.usuarioId = :usuarioId "
        + "ORDER BY p.fecha DESC, p.id DESC"
    )
    List<Prestamo> obtenerPrestamosPorUsuario(Long usuarioId);

    @Query("SELECT p FROM Prestamo p JOIN FETCH p.libro "
        + " ORDER BY p.fecha DESC, p.id DESC"
    )
    List<Prestamo> obtenerTodosLosPrestamos();


}
