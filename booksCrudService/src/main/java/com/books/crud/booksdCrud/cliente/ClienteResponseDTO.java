package com.books.crud.booksdCrud.cliente;

import java.time.LocalDate;

public record ClienteResponseDTO(
        Long id,
        String cpf,
        String foto,
        String nome,
        LocalDate dataNascimento
) {
    public static ClienteResponseDTO deClienteParaDTO(Cliente cliente){
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getCpf(),
                cliente.getFoto(),
                cliente.getNome(),
                cliente.getDataNascimento()
        );
    }
    public static Cliente dtoParEntidade(ClienteResponseDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setCpf(clienteDTO.cpf);
        cliente.setNome(clienteDTO.nome);
        cliente.setFoto(clienteDTO.foto);
        cliente.setDataNascimento(cliente.getDataNascimento());
        return cliente;
    }
}
