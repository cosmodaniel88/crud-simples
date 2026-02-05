package com.books.crud.booksdCrud.cliente;

import java.time.LocalDate;

public record ClienteDTO(
        Long id,
        String cpf,
        String foto,
        String nome,
        LocalDate dataNascimento
) {
    public static ClienteDTO deCliente(Cliente cliente){
        return new ClienteDTO(
                cliente.getId(),
                cliente.getCpf(),
                cliente.getFoto(),
                cliente.getNome(),
                cliente.getDataNascimento()
        );
    }
    public static Cliente dtoParEntidade(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setCpf(clienteDTO.cpf);
        cliente.setNome(clienteDTO.nome);
        cliente.setFoto(clienteDTO.foto);
        cliente.setDataNascimento(cliente.getDataNascimento());
        return cliente;
    }
}
