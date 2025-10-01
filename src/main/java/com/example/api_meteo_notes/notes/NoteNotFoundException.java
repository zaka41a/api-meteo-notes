package com.example.api_meteo_notes.notes;

/**
 * Exception métier claire pour 404.
 */
public class NoteNotFoundException extends RuntimeException {
  public NoteNotFoundException(Long id) {
    super("Note " + id + " introuvable");
  }
}
