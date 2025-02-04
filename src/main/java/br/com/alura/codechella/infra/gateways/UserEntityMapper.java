package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.User;
import br.com.alura.codechella.infra.persistence.UserEntity;

public class UserEntityMapper {
   public UserEntity toEntity(User user){
        return new UserEntity(user.getCpf(), user.getName(), user.getBirth(), user.getEmail());
    }
    public User toDomain(UserEntity userEntity){
        return new User(userEntity.getCpf(), userEntity.getNome(), userEntity.getNascimento(), userEntity.getEmail());
    }
}
