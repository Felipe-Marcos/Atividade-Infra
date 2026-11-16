package com.lab10.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class InfoController {

    private final String versao;

    public InfoController(@Value("${app.versao}") String versao) {
        this.versao = versao;
    }

    @GetMapping("/ola")
    public Map<String, String> ola() {
        return Map.of("mensagem", "Ola! API do Lab 10 no ar");
    }

    @GetMapping("/versao")
    public Map<String, String> versao() {
        return Map.of("versao", versao);
    }
}
