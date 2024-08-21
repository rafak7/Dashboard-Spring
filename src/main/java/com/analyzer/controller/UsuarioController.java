package com.analyzer.controller;

import com.analyzer.model.Usuario;
import com.analyzer.service.CargoService;
import com.analyzer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CargoService cargoService;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuario/listar";
    }

    @GetMapping("/usuarios/novo")
    public String novoUsuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("cargos", cargoService.listarTodos());
        return "usuario/novo";
    }

    @PostMapping("/usuarios")
    public String salvarUsuario(Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String editarUsuarioForm(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", usuarioService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id)));
        model.addAttribute("cargos", cargoService.listarTodos());
        return "usuario/editar";
    }

    @PostMapping("/usuarios/editar/{id}")
    public String atualizarUsuario(@PathVariable Long id, Usuario usuario) {
        usuario.setId(id);
        usuarioService.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/deletar/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarPorId(id);
        return "redirect:/usuarios";
    }
}
