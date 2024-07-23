package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.User;

import java.util.List;


public class ListarUsuarios {
    private final UserRepository repository;

    public ListarUsuarios(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> obterTodosUsuarios(){
        return this.repository.listarTodos();
    };
}
