package com.books.crud.booksdCrud.cliente;

import java.time.LocalDate;

public record ClienteResponseDTO(
        Long id,
        boolean ativo,
        String cpf,
        String foto,
        String nome,
        LocalDate dataNascimento
) {

}
