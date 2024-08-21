package com.analyzer.controller;

import com.analyzer.model.Feedback;
import com.analyzer.service.FeedbackService;
import com.analyzer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/feedbacks")
    public String listarFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackService.listarTodos());
        return "feedback/listar";
    }

    @GetMapping("/feedbacks/novo")
    public String novoFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "feedback/novo";
    }

    @PostMapping("/feedbacks")
    public String salvarFeedback(Feedback feedback) {
        feedbackService.salvar(feedback);
        return "redirect:/feedbacks";
    }

    @GetMapping("/feedbacks/editar/{id}")
    public String editarFeedbackForm(@PathVariable Long id, Model model) {
        model.addAttribute("feedback", feedbackService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id)));
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "feedback/editar";
    }

    @PostMapping("/feedbacks/editar/{id}")
    public String atualizarFeedback(@PathVariable Long id, Feedback feedback) {
        feedback.setId(id);
        feedbackService.salvar(feedback);
        return "redirect:/feedbacks";
    }

    @GetMapping("/feedbacks/deletar/{id}")
    public String deletarFeedback(@PathVariable Long id) {
        feedbackService.deletarPorId(id);
        return "redirect:/feedbacks";
    }
}
