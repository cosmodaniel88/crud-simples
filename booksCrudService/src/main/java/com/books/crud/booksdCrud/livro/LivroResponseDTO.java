package com.books.crud.booksdCrud.livro;

import java.math.BigDecimal;

public record LivroResponseDTO(
    Long id,
    String nome,
    Boolean ativo,
    String capa,
    BigDecimal valor,
    String descricao,
    Integer estoque
) {
}
