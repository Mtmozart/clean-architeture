package br.com.alura.codechella.domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("12345678999", "Jacque", LocalDate.parse("1990-09-08"), "email@email.com"));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("12345678999", "Jacque", LocalDate.parse("1990-09-08"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("", "Jacque", LocalDate.parse("1990-09-08"), "email@email.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FactoryUser factory = new FactoryUser();
        User user = factory.withNameCpfBith("123.456.789-99", "Emily",
                LocalDate.parse("2000-10-01"));

        Assertions.assertEquals("Emily", user.getName());

        user = factory.includesAddress("12345-999", 40, "apto 201");

        Assertions.assertEquals("apto 201", user.getAddress().getComplement()   );

    }
    @Test
    public void naoDeveCadastrarUsuarioMenor18Anos() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("123.456.789-99", "Jacque", LocalDate.parse("2020-09-08"), "email@email.com"));
        Assertions.assertEquals("A idade mínima exigida é 18 anos.", ex.getMessage());
    }

}
