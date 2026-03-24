package com.books.crud.booksdCrud.autor;

public record AutorResponseDTO(
        Long id,
        Boolean ativo,
        String nome,
        String foto
) {
}
