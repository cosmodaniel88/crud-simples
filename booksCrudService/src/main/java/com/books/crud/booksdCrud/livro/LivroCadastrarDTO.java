package com.books.crud.booksdCrud.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroCadastrarDTO(

    @NotBlank(message = "Favor, informe o nome do livro")
    String nome,

    String capa,

    @NotNull(message = "Favor, informe o valor do livro")
    Double valor,

    String descricao
) {
}
