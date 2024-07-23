package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.FactoryUser;
import br.com.alura.codechella.infra.gateways.UserEntityMapper;
import br.com.alura.codechella.infra.gateways.UserRepositoryJPA;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CriarUsuario criarUsuario(UserRepository userRepository) {
        return new CriarUsuario(userRepository);
    }
    @Bean
    ListarUsuarios listarUsuarios(UserRepository userRepository){
        return new ListarUsuarios(userRepository);
    }
    @Bean
    UserRepositoryJPA userRepositoryJPA(UsuarioRepository repository, UserEntityMapper mapper){
        return new UserRepositoryJPA(repository, mapper);
    }
    @Bean
    FactoryUser factoryUser(){
        return new FactoryUser();
    }
    @Bean
    UserEntityMapper userEntityMapper(){
        return new UserEntityMapper();
    }
}
