package com.analyzer.service;

import com.analyzer.model.Feedback;
import com.analyzer.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> listarTodos() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> buscarPorId(Long id) {
        return feedbackRepository.findById(id);
    }

    public Feedback salvar(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deletarPorId(Long id) {
        feedbackRepository.deleteById(id);
    }

    // Método para contar o número total de feedbacks
    public long count() {
        return feedbackRepository.count();
    }

    // Método para obter os feedbacks mais recentes
    public List<Feedback> findRecentFeedbacks() {
        return feedbackRepository.findTop10ByOrderByDataDesc();
    }
}
