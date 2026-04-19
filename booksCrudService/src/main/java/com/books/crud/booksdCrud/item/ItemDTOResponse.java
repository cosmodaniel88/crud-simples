package com.books.crud.booksdCrud.item;

import com.books.crud.booksdCrud.livro.Livro;

import java.math.BigDecimal;

public record ItemDTOResponse(

        Long id,
        Long livroId,
        String nomeLivro,//expondo uma entidade
        BigDecimal valorUnitario,
        Integer quantidade,
        BigDecimal valorTotalItem
) {
}
