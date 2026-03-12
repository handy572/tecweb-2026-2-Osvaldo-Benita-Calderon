package com.upiiz.CRUD.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/categorias")
public class CrudController {

    private List<Map<String, Object>> categorias = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categorias);
        return "lista";
    }

    @GetMapping("/crear")
    public String crear() {
        return "crear";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam int id,
                          @RequestParam String nombre,
                          @RequestParam String descripcion,
                          @RequestParam String fecha_creacion) {

        Map<String, Object> categoria = new HashMap<>();

        categoria.put("id", id);
        categoria.put("nombre", nombre);
        categoria.put("descripcion", descripcion);
        categoria.put("fecha", fecha_creacion);

        categorias.add(categoria);

        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {

        for (Map<String, Object> cat : categorias) {
            if ((int) cat.get("id") == id) {
                model.addAttribute("categoria", cat);
                return "editar";
            }
        }

        return "redirect:/categorias";
    }

    @PostMapping("/actualizar")
    public String actualizar(@RequestParam int id,
                             @RequestParam String nombre,
                             @RequestParam String descripcion,
                             @RequestParam String fecha_creacion) {

        for (Map<String, Object> cat : categorias) {
            if ((int) cat.get("id") == id) {
                cat.put("nombre", nombre);
                cat.put("descripcion", descripcion);
                cat.put("fecha", fecha_creacion);
                break;
            }
        }

        return "redirect:/categorias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {

        categorias.removeIf(cat -> (int) cat.get("id") == id);

        return "redirect:/categorias";
    }
}
