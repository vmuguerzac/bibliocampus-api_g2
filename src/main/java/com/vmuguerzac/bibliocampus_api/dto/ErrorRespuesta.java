package com.vmuguerzac.bibliocampus_api.dto;

import java.util.Map;

public record ErrorRespuesta(int estado, String mensaje, Map<String, String> errores) {

    public static ErrorRespuesta de(int estado, String mensaje){
        return new ErrorRespuesta(estado, mensaje, Map.of());
    }
    
}
