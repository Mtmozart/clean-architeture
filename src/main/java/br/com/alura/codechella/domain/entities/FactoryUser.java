package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public class FactoryUser {
    private User user;

    public User withNameCpfBith(String cpf, String name, LocalDate bith){
        this.user = new User(cpf, name, bith, "");
        return this.user;
    }
    public User includesAddress(String cep, Integer number, String complement){
        this.user.setAddress(new Address(cep, number, complement));
        return this.user;
    }
}
