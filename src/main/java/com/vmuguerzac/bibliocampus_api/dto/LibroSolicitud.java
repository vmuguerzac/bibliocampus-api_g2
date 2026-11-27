package com.vmuguerzac.bibliocampus_api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LibroSolicitud(
    @NotBlank(message = "El titulo es obligatorio")
    @Size(max=150, message = "El titulo admite como maximo 150 catacteres")
    String titulo, 
    
    @NotBlank(message = "El autor es obligatorio")
    @Size(max=120, message = "El autor admite como maximo 120 catacteres")
    String autor, 

    @NotBlank(message = "La categoria es obligatoria")
    @Size(max=60, message = "La categoria admite como maximo 60 catacteres")
    String categoria, 
    
    @Min(value = 1450, message = "El año debe ser 1450 o posterior")
    @Max(value = 2100, message = "El año no es valido")
    int anio,

    @Size(max=500, message = "La URL admite como maximo 500 catacteres")
    String portadaUrl, 

    @Min(value = 0, message = "Las copias no pueden ser negativas")
    int copiasDisponibles
){}
