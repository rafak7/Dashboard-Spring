package com.analyzer.controller;

import org.springframework.ui.Model;
import com.analyzer.model.Admin;
import com.analyzer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public String listarAdmins(Model model) {
        model.addAttribute("admins", adminService.listarTodos());
        return "admin/listar";
    }

    @GetMapping("/admins/novo")
    public String novoAdminForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/novo";
    }

    @PostMapping("/admins")
    public String salvarAdmin(Admin admin) {
        adminService.salvar(admin);
        return "redirect:/admins";
    }

    @GetMapping("/admins/editar/{id}")
    public String editarAdminForm(@PathVariable Long id, Model model) {
        model.addAttribute("admin", adminService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id)));
        return "admin/editar";
    }

    @PostMapping("/admins/editar/{id}")
    public String atualizarAdmin(@PathVariable Long id, Admin admin) {
        admin.setId(id);
        adminService.salvar(admin);
        return "redirect:/admins";
    }

    @GetMapping("/admins/deletar/{id}")
    public String deletarAdmin(@PathVariable Long id) {
        adminService.deletarPorId(id);
        return "redirect:/admins";
    }
}
