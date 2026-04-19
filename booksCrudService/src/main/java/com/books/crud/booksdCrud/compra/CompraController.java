package com.books.crud.booksdCrud.compra;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("compras")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public Compra registrarCompra(@RequestBody @Valid RegistrarCompraDTO registrarCompraDTO) {
        return compraService.registrarNovaCompra(registrarCompraDTO);
    }

}
