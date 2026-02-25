package com.books.crud.booksdCrud.cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteResponseDTO paraResponseDTO(Cliente cliente){
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getCpf(),
                cliente.getFoto(),
                cliente.getNome(),
                cliente.getDataNascimento()
        );
    }
    public Cliente paraEntidade(ClienteCriarDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setCpf(clienteDTO.cpf());
        cliente.setNome(clienteDTO.nome());
        cliente.setFoto(clienteDTO.foto());
        cliente.setDataNascimento(cliente.getDataNascimento());
        return cliente;
    }
}
