package com.vmuguerzac.bibliocampus_api.controladores;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vmuguerzac.bibliocampus_api.dto.ErrorRespuesta;

@RestControllerAdvice 
public class ManejadorErrores {
    // Error 400 por un campo invalido
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorRespuesta> validacion(MethodArgumentNotValidException ex){
        Map<String, String> errores = new LinkedHashMap<>();
        for(FieldError error: ex.getBindingResult().getFieldErrors()){
            errores.putIfAbsent(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(new ErrorRespuesta(400, "Hay datos invalidos", errores));
    }

    
}
