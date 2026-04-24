package com.books.crud.booksdCrud.item;

import com.books.crud.booksdCrud.compra.Compra;
import com.books.crud.booksdCrud.livro.Livro;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    private BigDecimal valorUnitario;
    private Integer quantidade;
    private BigDecimal valorTotalItem;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    public Item() {
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Item(Long id, Livro livro, Integer quantidade) {
        this.id = id;
        this.livro = livro;
        this.quantidade = quantidade;
        this.setLivro(livro);
    }

    public Long getId() {
        return id;
    }

    public void setLivro(Livro livro){
        this.livro = livro;
        this.valorUnitario = livro.getValor();
        this.valorTotalItem = this.valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
    public Livro getLivro() {
        return livro;
    }


    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }


    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotalItem() {
        return valorTotalItem;
    }

}
