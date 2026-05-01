package com.upiiz.examen2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public String listarVentas(Model model) {
        model.addAttribute("ventas", ventaService.listar());
        return "ventas/list";
    }

    @GetMapping("/nueva")
    public String nuevaVenta(Model model) {
        model.addAttribute("venta", new Venta());
        return "ventas/form";
    }

    @PostMapping("/guardar")
    public String guardarVenta(@ModelAttribute Venta venta) {
        ventaService.guardar(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/{id}/detalle")
    public String agregarProducto(@PathVariable Long id, Model model) {
        model.addAttribute("ventaId", id);
        model.addAttribute("detalle", new VentaDetalle());
        model.addAttribute("productos", ventaService.listaProductos());
        return "ventas/detalle";
    }

    @PostMapping("/{id}/detalle")
    public String guardarDetalle(@PathVariable Long id,
                                 @ModelAttribute VentaDetalle detalle) {
        ventaService.agregarProducto(id, detalle);
        return "redirect:/ventas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable Long id) {
        ventaService.eliminar(id);
        return "redirect:/ventas";
    }
}
