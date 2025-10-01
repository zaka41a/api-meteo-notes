package com.example.api_meteo_notes.notes;

import com.example.api_meteo_notes.notes.dto.NoteCreateRequest;
import com.example.api_meteo_notes.notes.dto.NoteUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Couche métier. @Transactional => une transaction par méthode.
 * Les entités modifiées sont flush/commit à la fin.
 */
@Service
@Transactional
public class NoteService {
  private final NoteRepository repo;
  public NoteService(NoteRepository repo){ this.repo = repo; }

  public List<Note> all(){ return repo.findAll(); }

  public Note create(NoteCreateRequest req){
    Note n = new Note();
    n.setTitre(req.titre());
    n.setContenu(req.contenu());
    return repo.save(n); // persist immédiat (id généré)
  }

  public Note one(Long id){
    return repo.findById(id).orElseThrow(() -> new NoteNotFoundException(id));
  }

  public Note update(Long id, NoteUpdateRequest req){
    Note n = one(id);            // charge l’entité managée par le contexte de persistance
    n.setTitre(req.titre());     // modification traquée
    n.setContenu(req.contenu());
    return n; // pas besoin de save() grâce à @Transactional (flush à la fin)
  }

  public void delete(Long id){
    if (!repo.existsById(id)) throw new NoteNotFoundException(id);
    repo.deleteById(id);
  }
}
