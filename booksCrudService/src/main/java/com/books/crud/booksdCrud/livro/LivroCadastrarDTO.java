package com.books.crud.booksdCrud.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record LivroCadastrarDTO(

    @NotBlank(message = "Favor, informe o nome do livro")
    String nome,

    String capa,

    @NotNull(message = "Favor, informe o valor do livro")
    BigDecimal valor,

    String descricao
) {
}
