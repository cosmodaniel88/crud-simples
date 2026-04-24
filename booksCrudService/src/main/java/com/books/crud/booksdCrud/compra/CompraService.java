package com.books.crud.booksdCrud.compra;

import com.books.crud.booksdCrud.cliente.Cliente;
import com.books.crud.booksdCrud.cliente.ClienteRepository;
import com.books.crud.booksdCrud.item.Item;
import com.books.crud.booksdCrud.item.RegistrarItemDTO;
import com.books.crud.booksdCrud.livro.Livro;
import com.books.crud.booksdCrud.livro.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    private final CompraRepository compraRepository;
    private final ClienteRepository clienteRepository;
    private final LivroRepository livroRepository;
    private final CompraMapper compraMapper;

    public CompraService(CompraRepository compraRepository, ClienteRepository clienteRepository, LivroRepository livroRepository, CompraMapper compraMapper) {
        this.compraRepository = compraRepository;
        this.clienteRepository = clienteRepository;
        this.livroRepository = livroRepository;
        this.compraMapper = compraMapper;
    }

    public Compra registrarNovaCompra(RegistrarCompraDTO registrarCompraDTO) {

        Compra compra = new Compra();

        compra.registrarMomentoDaCompra();

        Cliente cliente = clienteRepository.findById(registrarCompraDTO.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        compra.setCliente(cliente);

        for(RegistrarItemDTO itemDTO : registrarCompraDTO.itens()){
            Livro livro = livroRepository.findById(itemDTO.livroId())
                    .orElseThrow(() -> new NullPointerException("Livro não encontrado"));

            Item item = new Item();
            item.setQuantidade(itemDTO.quantidade());
            item.setLivro(livro);
            compra.adicionarItem(item);

        }
        compra.registrarCompra();

        return compraRepository.save(compra);

    }

    public List<CompraResponseDTO> getComprasPorCliente(Long clienteId){
        if(!clienteRepository.existsById(clienteId)){
            throw new NullPointerException("Cliente não encontrado");
        }
        return compraRepository.findByClienteId(clienteId).stream().map(compraMapper::paraResponseDTO).toList();

    }

    public void cancelarCompra(Compra compra) {
        if(compra.getCompraStatus() == CompraStatus.CANCELADA || compra.getCompraStatus() == CompraStatus.FINALIZADA){
            throw new IllegalStateException("Não é possivel realizar o cancelamento de compras com status Cancelada ou Finaliada");
        }
        compra.cancelarCompra();

    }
}
