package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.infra.gateways.UserRepositoryJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    UserRepositoryJPA createUserJPA(){
        return new UserRepositoryJPA();
    }

    @Bean
    CriarUsuario criarUsuario() {
        return new CriarUsuario(UserRepository userRepository);

    }
}
