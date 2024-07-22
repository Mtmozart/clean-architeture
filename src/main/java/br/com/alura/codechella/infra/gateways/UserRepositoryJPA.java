package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.User;
import br.com.alura.codechella.infra.persistence.UserEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;

public class UserRepositoryJPA implements UserRepository {

    private final UsuarioRepository repository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryJPA(UsuarioRepository repository, UserEntityMapper userEntityMapper) {
        this.repository = repository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User cadastrarUsuario(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        repository.save(userEntity);
        return userEntityMapper.toDomain(userEntity);

    }

    @Override
    public List<User> listarTodos() {
       // return repository.findAll();
        return null;
    }
}
