package com.books.crud.booksdCrud.autor;

import com.books.crud.booksdCrud.livro.Livro;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String foto;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;

    public Autor() {
    }

    public Autor(Long id, String nome, String foto) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setUrl(String url) {
        this.foto = url;
    }

    public void atualizar(String foto, String nome){
        if(foto != null){
            this.foto = foto;
        }
        if(nome != null){
            this.nome = nome;
        }
    }
}
