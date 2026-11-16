package com.lab10.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InfoController.class)
class InfoControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void olaRetornaMensagem() throws Exception {
        mvc.perform(get("/api/ola"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensagem").value("Ola! API do Lab 10 no ar"));
    }

    @Test
    void versaoRetornaValorPadrao() throws Exception {
        mvc.perform(get("/api/versao"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.versao").value("1.0.0"));
    }
}
