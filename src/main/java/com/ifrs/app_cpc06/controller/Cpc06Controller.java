package com.ifrs.app_cpc06.controller;

import com.ifrs.app_cpc06.service.Cpc06Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-word")
public class Cpc06Controller {
    @Autowired
    private Cpc06Service cpc06Service;

    @GetMapping
    public String cpc06(){
        return cpc06Service.Cpc06Service("Janssen");
    }
}