package br.com.alura.codechella.application.usecases;


import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.User;




public class CriarUsuario {
    private final UserRepository repository;

    public CriarUsuario(UserRepository repository) {
        this.repository = repository;
    }

    public User cadastrarUsuario(User user) {
        return repository.cadastrarUsuario(user);
    }

}
