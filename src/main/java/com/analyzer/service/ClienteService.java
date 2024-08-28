package com.analyzer.service;

import com.analyzer.model.Cliente;
import com.analyzer.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para salvar ou atualizar um Cliente
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para contar o número total de clientes
    public long count() {
        return clienteRepository.count();
    }

    // Outros métodos do serviço...
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
