package com.books.crud.booksdCrud.livro;

public record LivroResponseDTO(
    Long id,
    String nome,
    Boolean ativo,
    String capa,
    Double valor,
    String descricao,
    Integer estoque
) {
}
