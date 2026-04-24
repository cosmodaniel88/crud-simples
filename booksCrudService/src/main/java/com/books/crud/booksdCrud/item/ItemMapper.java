package com.books.crud.booksdCrud.item;

import com.books.crud.booksdCrud.livro.Livro;
import com.books.crud.booksdCrud.livro.LivroRepository;
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

    public Item paraEntidade(RegistrarItemDTO itemDTO, Livro livro){

        Item item = new Item();
        item.setQuantidade(itemDTO.quantidade());
        item.setLivro(livro);

        return item;


    }
}
