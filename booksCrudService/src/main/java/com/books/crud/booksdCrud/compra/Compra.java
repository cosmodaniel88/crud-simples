package com.books.crud.booksdCrud.compra;

import com.books.crud.booksdCrud.cliente.Cliente;
import com.books.crud.booksdCrud.item.Item;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
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
    private List<Item> itens = new ArrayList();

    @Column(nullable = false)
    private BigDecimal valorTotalCompra;

    @Column(nullable = false)
    private Instant momentoDaCompra;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, name = "compra_status", nullable = false)
    private CompraStatus compraStatus;

    public Compra() {
    }

    public void adicionarItem(Item item) {
        item.setCompra(this);
        itens.add(item);

        recalcularTotal();

    }

    public void recalcularTotal(){
        //zeramos o valor total
        this.valorTotalCompra = BigDecimal.ZERO;
        //Percorremos cada item da lista de itens
        for(Item item : itens){
            //incrementamos o valor ao valorTotalCompra de cada item
            this.valorTotalCompra = this.valorTotalCompra.add(item.getValorTotalItem());
        }

    }


    public Long getId() {
        return id;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorTotalCompra() {
        return valorTotalCompra;
    }

    public Instant getMomentoDaCompra() {
        return momentoDaCompra;
    }

    public void registrarMomentoDaCompra(){
        this.momentoDaCompra = Instant.now();
    }

    public void registrarCompra(){
        this.compraStatus = CompraStatus.ABERTA;
    }

    public CompraStatus getCompraStatus() {
        return this.compraStatus;
    }

    public void aguardarPagamento(){
        this.compraStatus = CompraStatus.AGUARDANDO_PAGAMENTO;
    }

    public void finalizarCompra(){
        this.compraStatus = CompraStatus.FINALIZADA;
    }
    public void cancelarCompra(){
        this.compraStatus = CompraStatus.CANCELADA;
    }
    }
