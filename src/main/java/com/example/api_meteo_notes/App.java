package com.example.api_meteo_notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Point d'entrée. @SpringBootApplication = scan des @Component/@Service/@Controller, autoconfig, etc.
 */
@SpringBootApplication
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
