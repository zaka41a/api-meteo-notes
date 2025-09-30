package com.example.api_meteo_notes.notes;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "notes")
public class Note {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 200)
  private String titre;

  @Lob
  private String contenu;

  @Column(nullable = false, updatable = false)
  private Instant createdAt = Instant.now();

  @Column(nullable = false)
  private Instant updatedAt = Instant.now();

  @PreUpdate
  void onUpdate() { this.updatedAt = Instant.now(); }

  // getters/setters
  public Long getId() { return id; }
  public String getTitre() { return titre; }
  public void setTitre(String titre) { this.titre = titre; }
  public String getContenu() { return contenu; }
  public void setContenu(String contenu) { this.contenu = contenu; }
  public Instant getCreatedAt() { return createdAt; }
  public Instant getUpdatedAt() { return updatedAt; }
}
