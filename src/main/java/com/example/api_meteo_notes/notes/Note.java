package com.example.api_meteo_notes.notes;

import jakarta.persistence.*;
import java.time.Instant;

/**
 * Entité JPA mappée sur la table "notes".
 * Gérée par Hibernate via Spring Data JPA.
 */
@Entity
@Table(name = "notes")
public class Note {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto
  private Long id;

  @Column(nullable = false, length = 200) // contrainte DB
  private String titre;

  @Lob // champ potentiellement long
  private String contenu;

  @Column(nullable = false, updatable = false)
  private Instant createdAt = Instant.now(); // set à la création

  @Column(nullable = false)
  private Instant updatedAt = Instant.now(); // mis à jour en @PreUpdate

  @PreUpdate
  void onUpdate() { this.updatedAt = Instant.now(); }

  // getters/setters (nécessaires à JPA)
  public Long getId() { return id; }
  public String getTitre() { return titre; }
  public void setTitre(String titre) { this.titre = titre; }
  public String getContenu() { return contenu; }
  public void setContenu(String contenu) { this.contenu = contenu; }
  public Instant getCreatedAt() { return createdAt; }
  public Instant getUpdatedAt() { return updatedAt; }
}
