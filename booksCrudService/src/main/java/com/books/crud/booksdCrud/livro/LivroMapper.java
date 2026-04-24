package com.books.crud.booksdCrud.livro;

import org.springframework.stereotype.Component;

@Component
public class LivroMapper {


    public LivroResponseDTO paraResponseDTO(Livro livro){
        return new LivroResponseDTO(
                livro.getId(),
                livro.getNome(),
                livro.estaAtivo(),
                livro.getCapa(),
                livro.getValor(),
                livro.getDescricao(),
                livro.getEstoque()
        );
    }
    public Livro paraEntidade(LivroCadastrarDTO livroDTO){
        Livro livro = new Livro();
        livro.setNome(livroDTO.nome());
        livro.setCapa(livroDTO.capa());
        livro.setValor(livroDTO.valor());
        livro.setDescricao(livroDTO.descricao());

        return livro;
    }
}
