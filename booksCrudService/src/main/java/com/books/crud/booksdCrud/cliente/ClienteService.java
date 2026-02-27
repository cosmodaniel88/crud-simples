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

    public ClienteResponseDTO cadastrarNovoCliente(ClienteCriarDTO clienteCriarDTO){

        if(clienteCriarDTO == null){
            throw new NullPointerException("Dados não enviados");
        }

        System.out.println(clienteCriarDTO);

        Cliente cliente = clienteRepository.save(clienteMapper.paraEntidade(clienteCriarDTO));

        return clienteMapper.paraResponseDTO(cliente);

    }

    public ClienteResponseDTO atualizarCliente(Long id, ClienteAtualizarDTO clienteAtualizarDTO){
            Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

            cliente.atualizar(
                    clienteAtualizarDTO.foto(),
                    clienteAtualizarDTO.nome(),
                    clienteAtualizarDTO.dataNascimento()
            );
            return clienteMapper.paraResponseDTO(cliente);
    }

}
