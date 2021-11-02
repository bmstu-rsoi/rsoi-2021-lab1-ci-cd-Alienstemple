package ru.borisovskaya.lab1cicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.borisovskaya.lab1cicd.controller.PersonController;

@//WebMvcTest(controllers = PersonController.class)
public class Lab1CicdApplicationTests {
    @Autowired
    private MockMvc mockMvc;

   // @Test
    public void listAllTest() throws Exception {
       // mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/persons"))
       //         .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
    }
}

