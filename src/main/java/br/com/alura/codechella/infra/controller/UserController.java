package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.domain.entities.FactoryUser;
import br.com.alura.codechella.domain.entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CriarUsuario userCreate;
    private final FactoryUser factory;

    public UserController(CriarUsuario userCreate, FactoryUser factory) {
        this.userCreate = userCreate;
        this.factory = factory;
    }


    @PostMapping
    public UserDto createUser(@RequestBody UserDto dto) {
        User user = factory.withNameCpfBithEmail(dto.cpf(), dto.nome(), dto.nascimento(), dto.email());
        User save =  this.userCreate.cadastrarUsuario(user);
        return new UserDto(save.getCpf(), save.getName(), save.getBirth(), save.getEmail());
    }

}
