package com.books.crud.booksdCrud.autor;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;

    public AutorService(AutorRepository autorRepository, AutorMapper autorMapper) {
        this.autorRepository = autorRepository;
        this.autorMapper = autorMapper;
    }

    //Buscar autor por id
    public AutorResponseDTO getAutorPorId(Long id){
        Autor autor = autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        return autorMapper.paraResponseDTO(autor);
    }

    //listar todos os autores
    public List<AutorResponseDTO> getTodosOsAutores(){
        return autorRepository.findAll().stream().map(autorMapper::paraResponseDTO).toList();
    }

    //Cadastrar novo autor
    public AutorResponseDTO cadastrarNovoAutor(AutorCriarDTO autorCriarDTO){

        if(autorCriarDTO == null){
            throw new NullPointerException("Dados não enviados");
        }

        Autor autor = autorRepository.save(autorMapper.paraEntidade(autorCriarDTO));

        return autorMapper.paraResponseDTO(autor);

    }

    //Atualizar um autor
    public AutorResponseDTO atualizarAutor(Long id, AutorAtualizarDTO autorAtualizarDTO){
        Autor autor = autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        autor.atualizar(
                autorAtualizarDTO.foto(),
                autorAtualizarDTO.nome()
        );

        autorRepository.save(autor);

        return autorMapper.paraResponseDTO(autor);
    }
    //Deletar um cliente por id
    public void deletarAutor(Long id){
        autorRepository.deleteById(id);
    }

}


