package com.example.api_meteo_notes.common;

import com.example.api_meteo_notes.notes.NoteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NoteNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Map<String,Object> handleNoteNotFound(NoteNotFoundException ex) {
    return Map.of(
      "timestamp", Instant.now().toString(),
      "status", 404,
      "error", ex.getMessage()
    );
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String,Object> handleValidation(MethodArgumentNotValidException ex) {
    Map<String,String> fields = new HashMap<>();
    ex.getBindingResult().getFieldErrors()
      .forEach(err -> fields.put(err.getField(), err.getDefaultMessage()));
    return Map.of(
      "timestamp", Instant.now().toString(),
      "status", 400,
      "error", "Validation error",
      "fields", fields
    );
  }
}
