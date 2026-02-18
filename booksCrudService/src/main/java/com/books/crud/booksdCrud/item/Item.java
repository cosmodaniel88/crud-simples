package com.books.crud.booksdCrud.item;

import com.books.crud.booksdCrud.livro.Livro;
import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    private Double valorUnitario;
    private Integer quantidade;
    private Double valorTotalItem;

    public Item() {
    }

    public Item(Long id, Livro livro, Integer quantidade) {
        this.id = id;
        this.livro = livro;
        this.quantidade = quantidade;
        this.definirValorUnitario(livro);
    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void definirValorUnitario(Livro livro) {
        this.valorUnitario = livro.getValor();
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotalItem() {
        return valorTotalItem;
    }

    public void definirValorTotal(Double valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }
}
