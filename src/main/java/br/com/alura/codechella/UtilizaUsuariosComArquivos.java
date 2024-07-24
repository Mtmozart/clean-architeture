package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.User;
import br.com.alura.codechella.infra.gateways.RepositorioEmArquivo;

import java.io.IOException;
import java.time.LocalDate;

public class UtilizaUsuariosComArquivos {
    public static void main(String[] args) throws IOException {
        RepositorioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new User("456.789.888-88", "João", LocalDate.parse("2000-10-15"), "joao@email.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new User("456.789.888-88", "Maria", LocalDate.parse("2000-10-15"), "maria@email.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new User("456.789.888-88", "Vinicios", LocalDate.parse("2000-10-15"), "vinicios@email.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new User("456.789.888-88", "Raphael", LocalDate.parse("2000-10-15"), "raphael@email.com"));

   // System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());
        repositorioDeUsuarioEmArquivo.gravarEmArquivo("users.txt");
    }
}
