package com.books.crud.booksdCrud.compra;

import com.books.crud.booksdCrud.cliente.Cliente;
import com.books.crud.booksdCrud.cliente.ClienteRepository;
import com.books.crud.booksdCrud.item.Item;
import com.books.crud.booksdCrud.item.RegistrarItemDTO;
import com.books.crud.booksdCrud.livro.Livro;
import com.books.crud.booksdCrud.livro.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private final CompraRepository compraRepository;
    private final ClienteRepository clienteRepository;
    private final LivroRepository livroRepository;

    public CompraService(CompraRepository compraRepository, ClienteRepository clienteRepository, LivroRepository livroRepository) {
        this.compraRepository = compraRepository;
        this.clienteRepository = clienteRepository;
        this.livroRepository = livroRepository;
    }

    public Compra registrarNovaCompra(RegistrarCompraDTO registrarCompraDTO) {

        Compra compra = new Compra();

        compra.registrarMomentoDaCompra();

        Cliente cliente = clienteRepository.findById(registrarCompraDTO.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        compra.definirCliente(cliente);

        for(RegistrarItemDTO itemDTO : registrarCompraDTO.itens()){
            Livro livro = livroRepository.findById(itemDTO.livroId())
                    .orElseThrow(() -> new NullPointerException("Livro não encontrado"));

            Item item = new Item();
            item.definirQuantidade(itemDTO.quantidade());
            item.setLivro(livro);
            compra.adicionarItem(item);

        }

        return compraRepository.save(compra);

    }
}
