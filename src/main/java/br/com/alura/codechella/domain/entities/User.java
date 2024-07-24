package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private String cpf;
    private String name;
    private LocalDate birth;
    private String email;
    private Address address;

    public User(String cpf, String name, LocalDate birth, String email) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("Cpf no padrão incorreto!");
        }
        this.cpf = cpf;
        this.name = name;
        if(Period.between(birth, LocalDate.now()).getYears() < 18){
            throw new IllegalArgumentException("A idade mínima exigida é 18 anos.");
        }
        this.birth = birth;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
