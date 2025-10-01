package com.example.api_meteo_notes.notes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO d'entrée pour créer une note.
 * record = immuable + auto-getters (req.titre()).
 * @NotBlank + @Size = contraintes de validation input.
 */
public record NoteCreateRequest(
  @NotBlank @Size(max=200) String titre,
  String contenu
) {}
