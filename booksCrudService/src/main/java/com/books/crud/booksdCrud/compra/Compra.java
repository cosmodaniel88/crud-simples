package com.books.crud.booksdCrud.compra;

import com.books.crud.booksdCrud.cliente.Cliente;
import com.books.crud.booksdCrud.item.Item;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "compra")
    private List<Item> items = new ArrayList();

    private Double valorTotalCompra;
    private LocalDateTime momentoDaCompra;




    public Compra() {
    }


    public Long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(Double valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    public LocalDateTime getMomentoDaCompra() {
        return momentoDaCompra;
    }

    public void setMomentoDaCompra(LocalDateTime momentoDaCompra) {
        this.momentoDaCompra = momentoDaCompra;
    }
}
