package com.books.crud.booksdCrud.compra;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{clienteId}/cliente")
    public Page<CompraResponseDTO> listarComprasPorCliente(@PathVariable Long clienteId, Pageable pageable) {
        return compraService.getComprasPorCliente(clienteId, pageable);
    }
}
