package com.example.api_meteo_notes.common;

import com.example.api_meteo_notes.notes.NoteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @RestControllerAdvice = intercepteur global des exceptions des contrôleurs REST.
 * Ici on transforme des exceptions Java en réponses JSON propres.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * 404 quand une note n'existe pas.
   * @ExceptionHandler capte l'exception correspondante.
   */
  @ExceptionHandler(NoteNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Map<String,Object> handleNoteNotFound(NoteNotFoundException ex) {
    return Map.of(
      "timestamp", Instant.now().toString(), // horodatage ISO
      "status", 404,
      "error", ex.getMessage()               // message de l'exception
    );
  }

  /**
   * 400 quand la validation @Valid échoue (ex: titre vide).
   * On renvoie les erreurs champ par champ.
   */
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
      "fields", fields // ex: {"titre": "must not be blank"}
    );
  }
}
