package com.books.crud.booksdCrud.item;

import com.books.crud.booksdCrud.livro.Livro;
import com.books.crud.booksdCrud.livro.LivroMapper;
import com.books.crud.booksdCrud.livro.LivroRepository;
import com.books.crud.booksdCrud.livro.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    private final LivroRepository livroRepository;

    public ItemMapper(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public ItemDTOResponse paraResponseDTO(Item item){
            return new ItemDTOResponse(
                    item.getId(),
                    item.getLivro().getId(),
                    item.getLivro().getNome(),
                    item.getValorUnitario(),
                    item.getQuantidade(),
                    item.getValorTotalItem()
            );
    }

    public Item paraEntidade(ItemCriarDTO itemDTO, Livro livro){

        Item item = new Item();
        item.setQuantidade(itemDTO.quantidade());
        item.setLivro(livro);

        return item;


    }
}
