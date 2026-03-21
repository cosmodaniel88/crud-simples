package com.books.crud.booksdCrud.autor;

import com.books.crud.booksdCrud.cliente.ClienteResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    public AutorResponseDTO paraResponseDTO(Autor autor){
        return new AutorResponseDTO(
                autor.getId(),
                autor.getNome(),
                autor.getFoto()
        );
    }
    public Autor paraEntidade(AutorCriarDTO autorDTO){
        Autor autor = new Autor();
        autor.setNome(autorDTO.nome());
        autor.setFoto(autorDTO.foto());

        return autor;
    }
}
