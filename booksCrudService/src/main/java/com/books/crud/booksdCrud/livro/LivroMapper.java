package com.books.crud.booksdCrud.livro;

import org.springframework.stereotype.Component;

@Component
public class LivroMapper {


    public LivroResponseDTO paraResponseDTO(Livro livro){
        return new LivroResponseDTO(
                livro.buscarId(),
                livro.buscarNome(),
                livro.estaAtivo(),
                livro.getCapa(),
                livro.getValor(),
                livro.getDescricao(),
                livro.getEstoque()
        );
    }
    public Livro paraEntidade(LivroCadastrarDTO livroDTO){
        Livro livro = new Livro();
        livro.definirNome(livroDTO.nome());
        livro.definirCapa(livroDTO.capa());
        livro.definirValor(livroDTO.valor());
        livro.setDescricao(livroDTO.descricao());

        return livro;
    }
}
