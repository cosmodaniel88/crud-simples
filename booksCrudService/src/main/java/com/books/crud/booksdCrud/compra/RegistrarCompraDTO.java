package com.books.crud.booksdCrud.compra;

import com.books.crud.booksdCrud.item.ItemCriarDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RegistrarCompraDTO(
        @NotNull
        Long clienteId,
        @NotNull
        List<ItemCriarDTO> itens
) {
}
