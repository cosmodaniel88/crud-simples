package com.books.crud.booksdCrud.cliente;
import com.books.crud.booksdCrud.livro.Livro;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void atualizar(String foto, String nome, LocalDate dataNascimento){
        if(foto != null){
            this.foto = foto;
        }
        if(nome != null){
            this.nome = nome;
        }
        if(dataNascimento != null){
            this.dataNascimento = dataNascimento;
        }
    }
}
