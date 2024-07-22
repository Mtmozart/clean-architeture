package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.User;

import java.util.List;

public interface UserRepository {
    User cadastrarUsuario(User user);

    List<User> listarTodos();

}
