package com.books.crud.booksdCrud.cliente;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
//Busca um cliente por ID
    public ClienteResponseDTO getClientePorId(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return ClienteResponseDTO.deClienteParaDTO(cliente);
    }
//Lista todos os clientes
    public List<ClienteResponseDTO> getTodosOsClientes(){
        return clienteRepository.findAll().stream().map(ClienteResponseDTO::deClienteParaDTO).toList();
    }
}
