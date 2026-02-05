package com.books.crud.booksdCrud.cliente;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Cliente {
    private Long id;
    private String cpf;
    private String foto;
    private String nome;
    private LocalDate dataNascimento;

    public Cliente(){

    }

    public Cliente(Long id, String cpf, String foto, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.cpf = cpf;
        this.foto = foto;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
