package com.upiiz.practica2;
import com.upiiz.services.UsuarioService;
import com.upiiz.services.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UsuarioService userService;
    private final MailService mailService;

    public AuthController(UsuarioService userService, MailService mailService) {
        this.userService = userService;
        this.mailService = mailService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(String email, String password, Model model) {
        if (userService.login(email, password).isPresent()) {
            return "redirect:/pedidos";
        }
        model.addAttribute("error", "Error login");
        return "login";
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String registrar(String email, String password) {
        var u = new com.tuapp.entities.Usuario();
        u.setEmail(email);
        u.setPassword(password);
        userService.registrar(u);
        return "redirect:/login";
    }

    @GetMapping("/recuperar")
    public String recuperar() {
        return "recuperar";
    }

    @PostMapping("/recuperar")
    public String recuperarPost(String email) {
        var user = userService.buscarPorEmail(email);
        user.ifPresent(u -> mailService.enviarCorreo(email, u.getPassword()));
        return "login";
    }
}