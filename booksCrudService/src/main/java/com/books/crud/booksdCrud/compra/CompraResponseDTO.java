package com.books.crud.booksdCrud.compra;

import com.books.crud.booksdCrud.cliente.Cliente;
import com.books.crud.booksdCrud.item.ItemDTOResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record CompraResponseDTO(
        Long id,
        Cliente cliente,
        List<ItemDTOResponse> itens,
        BigDecimal valorTotalCompra,
        LocalDateTime momentoDaCompra
) {

}
