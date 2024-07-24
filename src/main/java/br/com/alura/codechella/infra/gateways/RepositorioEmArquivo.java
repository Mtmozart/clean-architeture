package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEmArquivo implements UserRepository {
    List<User> users= new ArrayList<>();
    @Override
    public User cadastrarUsuario(User user) {
         this.users.add(user);
         return user;
    }

    @Override
    public List<User> listarTodos() {
        return  this.users;
    }

    public void gravarEmArquivo(String nome) throws IOException {
        FileWriter fileWriter = new FileWriter(nome);
        fileWriter.write(this.users.toString());
        fileWriter.close();
    }
}
