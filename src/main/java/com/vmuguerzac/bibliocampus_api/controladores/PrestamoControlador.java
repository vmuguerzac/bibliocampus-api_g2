package com.vmuguerzac.bibliocampus_api.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmuguerzac.bibliocampus_api.dto.PrestamoRespuesta;
import com.vmuguerzac.bibliocampus_api.dto.PrestamoSolicitud;
import com.vmuguerzac.bibliocampus_api.servicios.PrestamoServicio;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/api/prestamos")
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

    //GET - obtener mis prestamos
    @GetMapping("/mios")
    public List<PrestamoRespuesta> listarMios() {
        return prestamoServicio.listarMios(USUARIO_DEMO);
    }
    
    
    // POST - Hacer el prestamo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) 
    public PrestamoRespuesta solicitarLibro(@Valid @RequestBody PrestamoSolicitud prestamo) {
        return prestamoServicio.solitarLibro(USUARIO_DEMO, prestamo.libroId());
    }
    
}
