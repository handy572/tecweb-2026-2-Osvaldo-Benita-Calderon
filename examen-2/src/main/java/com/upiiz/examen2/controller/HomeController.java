package com.upiiz.examen2.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("ventas", 53);
        model.addAttribute("productos", 44);
        model.addAttribute("usuarios", 65);
        model.addAttribute("ordenes", 150);

        model.addAttribute("ventasMensuales", List.of(20,40,30,15,80,25,90));

        return "dashboard";
    }
}
