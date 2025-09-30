package com.example.api_meteo_notes.notes;

import com.example.api_meteo_notes.notes.dto.NoteCreateRequest;
import com.example.api_meteo_notes.notes.dto.NoteUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {
  private final NoteService service;
  public NotesController(NoteService service){ this.service = service; }

  @GetMapping
  public List<Note> list(){ return service.all(); }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Note create(@Valid @RequestBody NoteCreateRequest req){
    return service.create(req);
  }

  @GetMapping("/{id}")
  public Note one(@PathVariable Long id){ return service.one(id); }

  @PutMapping("/{id}")
  public Note update(@PathVariable Long id, @Valid @RequestBody NoteUpdateRequest req){
    return service.update(id, req);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id){ service.delete(id); }
}
