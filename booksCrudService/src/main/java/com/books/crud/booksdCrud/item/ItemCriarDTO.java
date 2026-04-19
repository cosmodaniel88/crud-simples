package com.books.crud.booksdCrud.item;

import com.books.crud.booksdCrud.livro.Livro;
import jakarta.validation.constraints.NotNull;

public record ItemCriarDTO(

        @NotNull
        Long livroId,

        @NotNull
        int quantidade
) {
}
