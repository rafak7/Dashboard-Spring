package com.analyzer.controller;

import com.analyzer.model.Ura;

import com.analyzer.service.UraService;
import com.analyzer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class UraController {

    @Autowired
    private UraService uraService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/ura")
    public String ura(Model model) {
        List<Ura> uras = uraService.listarTodos();
        model.addAttribute("ura", uras);
        return "ura/listar";
    }

    @GetMapping("/ura/novo")
    public String novaUra(Model model) {
        model.addAttribute("ura", new Ura());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "ura/novo";
    }

    @PostMapping("/ura")
    public String salvarUra(Ura ura) {
        uraService.salvar(ura);
        return "redirect:/ura";
    }

    @GetMapping("/ura/editar/{id}")
    public String editarUra(@PathVariable Long id, Model model) {
        model.addAttribute("ura", uraService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id)));
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "ura/editar";
    }

    @PutMapping("/ura/editar/{id}")
    public String atualizarUra(@PathVariable Long id, Ura ura){
        ura.setId(id);
        uraService.salvar(ura);
        return "redirect:/ura";
    }

    @GetMapping("/ura/deletar/{id}")
    public String deletarUra(@PathVariable Long id){
        uraService.deletarPorId(id);
        return "redirect:/ura";
    }

}
