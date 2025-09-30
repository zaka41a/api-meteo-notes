package com.example.api_meteo_notes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MeteoTest {
  @Autowired MockMvc mvc;

  @Test
  void meteoOk() throws Exception {
    mvc.perform(get("/meteo"))
       .andExpect(status().isOk())
       .andExpect(jsonPath("$.temperature_c").exists());
  }
}
