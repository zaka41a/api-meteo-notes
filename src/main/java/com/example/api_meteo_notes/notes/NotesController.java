package com.example.api_meteo_notes.notes;

import com.example.api_meteo_notes.notes.dto.NoteCreateRequest;
import com.example.api_meteo_notes.notes.dto.NoteUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST /notes (JSON in/out).
 * @RestController = @Controller + @ResponseBody
 */
@RestController
@RequestMapping("/notes")
public class NotesController {
  private final NoteService service;
  public NotesController(NoteService service){ this.service = service; }

  /**
   * GET /notes -> liste toutes les notes.
   */
  @GetMapping
  public List<Note> list(){ return service.all(); }

  /**
   * POST /notes -> crée une note (201 Created).
   * @Valid déclenche la validation des annotations dans le DTO.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Note create(@Valid @RequestBody NoteCreateRequest req){
    return service.create(req);
  }

  /**
   * GET /notes/{id} -> récupère une note (404 si absente).
   */
  @GetMapping("/{id}")
  public Note one(@PathVariable Long id){ return service.one(id); }

  /**
   * PUT /notes/{id} -> met à jour une note.
   * Retourne la note modifiée.
   */
  @PutMapping("/{id}")
  public Note update(@PathVariable Long id, @Valid @RequestBody NoteUpdateRequest req){
    return service.update(id, req);
  }

  /**
   * DELETE /notes/{id} -> supprime (204 No Content).
   */
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id){ service.delete(id); }
}
