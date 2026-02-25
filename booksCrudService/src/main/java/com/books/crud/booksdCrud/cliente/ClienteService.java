package com.books.crud.booksdCrud.cliente;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    //Busca um cliente por ID
    public ClienteResponseDTO getClientePorId(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return clienteMapper.paraResponseDTO(cliente);
    }
//Lista todos os clientes
    public List<ClienteResponseDTO> getTodosOsClientes(){
        return clienteRepository.findAll().stream().map(clienteMapper::paraResponseDTO).toList();
    }
}
