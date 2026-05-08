package com.upiiz.calculadora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculadoraController {
    @GetMapping()
    public String calculadora() {
        return "calculadora";
    }

}
