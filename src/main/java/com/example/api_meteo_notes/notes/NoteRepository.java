package com.example.api_meteo_notes.notes;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository CRUD prêt à l'emploi : findAll, findById, save, deleteById...
 */
public interface NoteRepository extends JpaRepository<Note, Long> {}
