package com.upiiz.cientifica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CientificaController {
    @GetMapping()
    public String cientifica(){
        return "cientifica";
    }
}
