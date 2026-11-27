package com.vmuguerzac.bibliocampus_api.dto;

import jakarta.validation.constraints.NotNull;

public record PrestamoSolicitud(
    @NotNull(message = "El libro es obligatorio") 
    Long libroId
){}
