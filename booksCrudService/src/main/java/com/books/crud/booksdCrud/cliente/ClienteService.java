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
//Cadastrar novo cliente
    public ClienteResponseDTO cadastrarNovoCliente(ClienteCriarDTO clienteCriarDTO){

        if(clienteCriarDTO == null){
            throw new NullPointerException("Dados não enviados");
        }

        Cliente cliente = clienteRepository.save(clienteMapper.paraEntidade(clienteCriarDTO));

        return clienteMapper.paraResponseDTO(cliente);
    }
//Atualizar um cliente
    public ClienteResponseDTO atualizarCliente(Long id, ClienteAtualizarDTO clienteAtualizarDTO){
            Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

            cliente.atualizar(
                    clienteAtualizarDTO.foto(),
                    clienteAtualizarDTO.nome(),
                    clienteAtualizarDTO.dataNascimento()
            );
            return clienteMapper.paraResponseDTO(cliente);
    }
//Deletar um cliente por id
    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public ClienteResponseDTO softDeleteCliente(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if(cliente.isAtivo()){
            cliente.desativar();
        }
        clienteRepository.save(cliente);
        return clienteMapper.paraResponseDTO(cliente);
    }

    public ClienteResponseDTO ativarCliente(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if(!cliente.isAtivo()){
            cliente.ativar();
        }
        clienteRepository.save(cliente);

        return clienteMapper.paraResponseDTO(cliente);
    }

}
