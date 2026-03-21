package com.books.crud.booksdCrud.autor;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record AutorCriarDTO(

        @NotBlank(message = "Nome obrigatório")
        String nome,

        String foto
) {
}
