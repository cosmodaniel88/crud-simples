package com.books.crud.booksdCrud.livro;

public record LivroAtualizarDTO(

    String nome,

    String capa,

    Double valor,

    String descricao
) {
}
