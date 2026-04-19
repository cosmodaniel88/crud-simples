package com.books.crud.booksdCrud.item;

import jakarta.validation.constraints.NotNull;

public record RegistrarItemDTO(

        @NotNull
        Long livroId,

        @NotNull
        int quantidade
) {
}
