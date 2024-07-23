package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.FactoryUser;
import br.com.alura.codechella.domain.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CriarUsuario userCreate;
    private final FactoryUser factory;
    private final ListarUsuarios listarUsuarios;

    public UserController(CriarUsuario userCreate, FactoryUser factory, ListarUsuarios listarUsuarios) {
        this.userCreate = userCreate;
        this.factory = factory;
        this.listarUsuarios = listarUsuarios;
    }


    @PostMapping
    public UserDto createUser(@RequestBody UserDto dto) {
        User user = factory.withNameCpfBithEmail(dto.cpf(), dto.nome(), dto.nascimento(), dto.email());
        User save =  this.userCreate.cadastrarUsuario(user);
        return new UserDto(save.getCpf(), save.getName(), save.getBirth(), save.getEmail());
    }

    @GetMapping
    public List<UserDto> createUser() {
        return this.listarUsuarios.obterTodosUsuarios().stream()
                .map(u -> new UserDto(u.getCpf(), u.getName(), u.getBirth(), u.getEmail()))
                .collect(Collectors.toUnmodifiableList());

    }

}
