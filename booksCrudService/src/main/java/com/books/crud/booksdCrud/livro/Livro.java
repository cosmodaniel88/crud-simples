package com.books.crud.booksdCrud.livro;

import com.books.crud.booksdCrud.autor.Autor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private boolean ativo;
    private String capa;
    private Double valor;

    @ManyToMany
    @JoinTable(
            name="livro_autor",
            joinColumns = @JoinColumn(name="livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores = new ArrayList<>();

    private String descricao;
    private Integer estoque;


    public Livro() {
        this.ativo = true;
    }

    public Livro(Long id, String nome, String capa, Double valor, String descricao, Integer estoque) {
        this.id = id;
        this.nome = nome;
        this.ativo = true;
        this.capa = capa;
        this.valor = valor;
        this.descricao = descricao;
        this.estoque = estoque;
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

    public boolean isAtivo(){
        return this.ativo;
    }

    public void desativar(){
        if(this.isAtivo()){
            this.ativo = false;
        }
    }
    public void ativar(){
        if(!this.isAtivo()){
            this.ativo = true;
        }
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void atualizar(String nome, String capa, Double valor, String descricao) {
        if(nome != null){
            this.nome = nome;
        }
        if(capa != null){
        this.capa = capa;
        }
        if(valor != null){
        this.valor = valor;
       }
        if(descricao != null){
        this.descricao = descricao;
        }
    }
}
