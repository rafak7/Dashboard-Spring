package com.analyzer.service;

import com.analyzer.model.Cargo;
import com.analyzer.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    // Método para salvar ou atualizar um Cargo
    public Cargo salvar(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    // Método para contar o número total de cargos
    public long count() {
        return cargoRepository.count();
    }

    // Outros métodos do serviço...
    public List<Cargo> listarTodos() {
        return cargoRepository.findAll();
    }

    public Optional<Cargo> buscarPorId(Long id) {
        return cargoRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        cargoRepository.deleteById(id);
    }
}
