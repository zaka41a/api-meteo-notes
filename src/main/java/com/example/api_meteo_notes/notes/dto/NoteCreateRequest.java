package com.example.api_meteo_notes.notes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NoteCreateRequest(
  @NotBlank @Size(max=200) String titre,
  String contenu
) {}
