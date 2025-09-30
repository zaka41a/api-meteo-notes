package com.example.api_meteo_notes.notes;

public class NoteNotFoundException extends RuntimeException {
  public NoteNotFoundException(Long id) {
    super("Note " + id + " introuvable");
  }
}
