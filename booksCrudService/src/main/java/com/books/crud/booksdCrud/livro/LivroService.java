package com.books.crud.booksdCrud.livro;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;

    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper) {
        this.livroRepository = livroRepository;
        this.livroMapper = livroMapper;
    }

    //buscar livro por id
    public LivroResponseDTO getLivroPorId(Long id){
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        return livroMapper.paraResponseDTO(livro);
    }

    //listar todos os livros
    public List<LivroResponseDTO> getTodosOsLivor(){
        return livroRepository.findAll().stream().map(livroMapper::paraResponseDTO).toList();
    }

    //cadastrar novo livro
    public LivroResponseDTO cadastrarNovoLivro(LivroCadastrarDTO livroCadastrarDTO){
        if(livroCadastrarDTO == null){
            throw new NullPointerException("Dados não enviados");
        }

        Livro livro = livroRepository.save(livroMapper.paraEntidade(livroCadastrarDTO));

        return livroMapper.paraResponseDTO(livro);
    }

    //Atualizar um livro
    public LivroResponseDTO atualizarLivro(Long id, LivroAtualizarDTO livroAtualizarDTO){
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.atualizar(
                livroAtualizarDTO.nome(),
                livroAtualizarDTO.capa(),
                livroAtualizarDTO.valor(),
                livroAtualizarDTO.descricao()
        );

       return livroMapper.paraResponseDTO(livroRepository.save(livro));
    }

    //Deleta um livro por id
    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }

    //soft delete
    public LivroResponseDTO softDeleteLivro(Long id){
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new NullPointerException("Livro não encontrado"));

        if(livro.isAtivo()){
            livro.desativar();
        }
        return livroMapper.paraResponseDTO(livroRepository.save(livro));
    }

    //Ativar
    public LivroResponseDTO ativarLivro(Long id){
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new NullPointerException("Livro não encontrado"));
        if(!livro.isAtivo()){
            livro.ativar();
        }

        return livroMapper.paraResponseDTO(livroRepository.save(livro));
    }
}
