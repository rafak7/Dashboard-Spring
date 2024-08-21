package com.analyzer.controller;

import com.analyzer.model.Cargo;
import com.analyzer.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping("/cargos")
    public String listarCargos(Model model) {
        model.addAttribute("cargos", cargoService.listarTodos());
        return "cargo/listar";
    }

    @GetMapping("/cargos/novo")
    public String novoCargoForm(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "cargo/novo";
    }

    @PostMapping("/cargos")
    public String salvarCargo(Cargo cargo) {
        cargoService.salvar(cargo);
        return "redirect:/cargos";
    }

    @GetMapping("/cargos/editar/{id}")
    public String editarCargoForm(@PathVariable Long id, Model model) {
        model.addAttribute("cargo", cargoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id)));
        return "cargo/editar";
    }

    @PostMapping("/cargos/editar/{id}")
    public String atualizarCargo(@PathVariable Long id, Cargo cargo) {
        cargo.setId(id);
        cargoService.salvar(cargo);
        return "redirect:/cargos";
    }

    @GetMapping("/cargos/deletar/{id}")
    public String deletarCargo(@PathVariable Long id) {
        cargoService.deletarPorId(id);
        return "redirect:/cargos";
    }
}
