package com.example.api_meteo_notes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Démo simple : endpoint GET /meteo qui renvoie une météo aléatoire (JSON).
 */
@RestController
public class WeatherController {
  private static final String[] CONDITIONS = {
    "ensoleillé","nuageux","pluie légère","averses","orage","partiellement couvert"
  };

  @GetMapping("/meteo")
  public Map<String,Object> meteoDuJour() {
    var r = ThreadLocalRandom.current();
    return Map.of(
      "date", LocalDate.now().toString(),
      "ville", "Localhost",
      "temperature_c", r.nextInt(12, 31),
      "condition", CONDITIONS[r.nextInt(CONDITIONS.length)],
      "humidite_pct", r.nextInt(30, 91)
    );
  }
}
