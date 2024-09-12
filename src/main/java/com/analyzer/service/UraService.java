package com.analyzer.service;

import com.analyzer.model.Ura;
import com.analyzer.repository.UraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UraService {

    @Autowired
    private UraRepository uraRepository;

    public List<Ura> listarTodos() {
        return uraRepository.findAll();
    }

    public Optional<Ura> buscarPorId(Long id) {
        return uraRepository.findById(id);
    }

    @Transactional
    public Ura salvar(Ura ura) {
        return uraRepository.save(ura);
    }

    @Transactional
    public void deletarPorId(Long id) {
        uraRepository.deleteById(id);
    }

    public long count() {
        return uraRepository.count();
    }
}
