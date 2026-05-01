package com.upiiz.examen2.controller;
import com.upiiz.services.UsuarioService;
import com.upiiz.services.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new Usuario());
        return "auth/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute Usuario user) {
        return "redirect:/auth/login";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "auth/forgot-password";
    }

    @PostMapping("/forgot-password")
    public String sendRecoveryEmail(@RequestParam String email) {
        return "redirect:/auth/login?recoverySent";
    }
}