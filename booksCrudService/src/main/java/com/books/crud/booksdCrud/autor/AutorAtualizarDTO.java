package com.books.crud.booksdCrud.autor;

import jakarta.validation.constraints.NotBlank;

public record AutorAtualizarDTO(
        String nome,
        String foto

) {
}
