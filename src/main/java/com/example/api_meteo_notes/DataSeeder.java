package com.example.api_meteo_notes;

import com.example.api_meteo_notes.notes.Note;
import com.example.api_meteo_notes.notes.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Seed de données au démarrage (dev).
 * CommandLineRunner s’exécute après le bootstrap de l’appli.
 */
@Configuration
public class DataSeeder {
  @Bean
  CommandLineRunner seedNotes(NoteRepository repo) {
    return args -> {
      if (repo.count() == 0) {
        Note a = new Note(); a.setTitre("Bienvenue"); a.setContenu("Ceci est une note d'exemple");
        Note b = new Note(); b.setTitre("À faire");   b.setContenu("Apprendre Spring Boot");
        Note c = new Note(); c.setTitre("Idée");      c.setContenu("Construire une petite API");
        repo.save(a); repo.save(b); repo.save(c);
      }
    };
  }
}
