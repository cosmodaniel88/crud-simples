package com.books.crud.booksdCrud.cliente;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping()
    public List<ClienteResponseDTO> getTodosOsClientes(){
        return clienteService.getTodosOsClientes();
    }

    @PostMapping()
    public ClienteResponseDTO criarNovoCliente(@Valid @RequestBody ClienteCriarDTO clienteCriarDTO){
        return clienteService.cadastrarNovoCliente(clienteCriarDTO);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizarCliente(@PathVariable Long id, @Valid @RequestBody ClienteAtualizarDTO clienteAtualizarDTO){
        return clienteService.atualizarCliente(id, clienteAtualizarDTO);
    }
}
