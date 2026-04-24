package com.books.crud.booksdCrud.compra;

import com.books.crud.booksdCrud.cliente.Cliente;
import com.books.crud.booksdCrud.cliente.ClienteCriarDTO;
import com.books.crud.booksdCrud.cliente.ClienteMapper;
import com.books.crud.booksdCrud.cliente.ClienteResponseDTO;
import com.books.crud.booksdCrud.item.ItemMapper;
import org.springframework.stereotype.Component;

@Component
public class CompraMapper {

    private final ItemMapper itemMapper;

    private final ClienteMapper clienteMapper;

    public CompraMapper(ItemMapper itemMapper, ClienteMapper clienteMapper) {
        this.itemMapper = itemMapper;
        this.clienteMapper = clienteMapper;
    }

    public CompraResponseDTO paraResponseDTO(Compra compra){
        return new CompraResponseDTO(
                compra.getId(),
                clienteMapper.paraResponseDTO(compra.getCliente()),
                compra.getItens().stream().map(itemMapper::paraResponseDTO).toList(),
                compra.getValorTotalCompra(),
                compra.getMomentoDaCompra()

        );
    }
    public Cliente paraEntidade(ClienteCriarDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setCpf(clienteDTO.cpf());
        cliente.setNome(clienteDTO.nome());
        cliente.setFoto(clienteDTO.foto());
        cliente.setDataNascimento(clienteDTO.dataNascimento());
        return cliente;
    }
}
