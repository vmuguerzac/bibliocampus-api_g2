package com.vmuguerzac.bibliocampus_api.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmuguerzac.bibliocampus_api.dto.PrestamoRespuesta;
import com.vmuguerzac.bibliocampus_api.dto.PrestamoSolicitud;
import com.vmuguerzac.bibliocampus_api.servicios.PrestamoServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "http://localhost:4200")
public class PrestamoControlador {
    private static final Long USUARIO_DEMO = 1L;

    private final PrestamoServicio prestamoServicio;

    public PrestamoControlador(PrestamoServicio instancia){
        this.prestamoServicio = instancia;
    }

    // GET - Obtener todos
    @GetMapping
    public List<PrestamoRespuesta> obtenerTodosPrestamos() {
        return prestamoServicio.listarTodosPrestamos();
    }
    
    // POST - Hacer el prestamo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) 
    public PrestamoRespuesta solicitarLibro(@RequestBody PrestamoSolicitud prestamo) {
        return prestamoServicio.solitarLibro(USUARIO_DEMO, prestamo.libroId());
    }
    
}
