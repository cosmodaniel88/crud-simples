package com.books.crud.booksdCrud.livro;

import java.math.BigDecimal;

public record LivroAtualizarDTO(

    String nome,

    String capa,

    BigDecimal valor,

    String descricao
) {
}
