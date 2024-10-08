package com.ifrs.app_cpc06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class MainController {
    // Mapeia a URL raiz (/) para a página index.html
    @GetMapping
    public String index() {
        String index = "index";
        return index; // Retorna o nome do arquivo HTML (sem a extensão)
    }
}
