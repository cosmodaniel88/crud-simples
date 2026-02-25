package com.books.crud.booksdCrud.cliente;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record ClienteCriarDTO(
        @NotBlank (message = "CPF obrigatório")
        String cpf,

        String foto,

        @NotBlank(message = "Nome obrigatório")
        String nome,

        @NotNull(message = "Data de nascimento obrigatória")
        @Past (message = "Data de nascimento deve estar no passado")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dataNascimento

) {
}
