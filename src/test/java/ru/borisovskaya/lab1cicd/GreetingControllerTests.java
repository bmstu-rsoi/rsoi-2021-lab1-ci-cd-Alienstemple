package ru.borisovskaya.lab1cicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "Vasya");
        params.add("age", "21");
        params.add("address", "Moscow");
        params.add("work", "rzd");

        this.mockMvc.perform(get("/greeting").params(params))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Person{" +
                        ", name='" + "Vasya" + '\'' +
                        ", age=" + "21" +
                        ", address='" + "Moscow" + '\'' +
                        ", work='" + "rzd" + '\'' +
                        '}'));
    }

}
