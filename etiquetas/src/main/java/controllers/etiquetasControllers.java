package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class etiquetasControllers {
    private List<String> etiquetas = Arrays.asList(
            "html", "head", "body",
            "p", "h1", "h2", "h3", "span", "strong", "em",
            "a", "img",
            "ul", "ol", "li",
            "table", "tr", "th", "td",
            "form");
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("etiquetas", etiquetas);
        return "index";
    }
    @GetMapping("/etiqueta/{name}")
    public String etiqueta(@PathVariable String name, Model model) {
        int index = etiquetas.indexOf(name);
        String prev = index > 0 ? etiquetas.get(index - 1) : null;
        String next = index < etiquetas.size() - 1 ? etiquetas.get(index + 1) : null;
        model.addAttribute("etiquetas", name);
        model.addAttribute("prev", prev);
        model.addAttribute("next", next);
        return "etiqueta";
    }
}