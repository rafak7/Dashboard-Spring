package com.analyzer.controller;

import com.analyzer.service.FeedbackService;
import com.analyzer.service.UsuarioService;
import com.analyzer.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private CargoService cargoService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("totalUsuarios", usuarioService.count());
        model.addAttribute("totalFeedbacks", feedbackService.count());
        model.addAttribute("totalCargos", cargoService.count());

        model.addAttribute("feedbacksRecentes", feedbackService.findRecentFeedbacks());

        return "admin/dashboard";
    }
}
