package com.books.crud.booksdCrud.cliente;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record ClienteAtualizarDTO(

        String foto,

        String nome,

        @Past(message = "Data de nascimento deve estar no passado")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dataNascimento
) {
}
