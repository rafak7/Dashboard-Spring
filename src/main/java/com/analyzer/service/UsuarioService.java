package com.analyzer.service;

import com.analyzer.model.Usuario;
import com.analyzer.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para salvar ou atualizar um Usuario
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Método para contar o número total de usuários
    public long count() {
        return usuarioRepository.count();
    }

    // Outros métodos do serviço...
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
