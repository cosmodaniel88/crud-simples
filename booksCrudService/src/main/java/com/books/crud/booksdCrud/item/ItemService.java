package com.books.crud.booksdCrud.item;

import com.books.crud.booksdCrud.livro.Livro;
import com.books.crud.booksdCrud.livro.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final LivroRepository livroRepository;


    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper, LivroRepository livroRepository) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.livroRepository = livroRepository;
    }

    public void cadastrarNovoItem(ItemCriarDTO itemCriarDTO){

        Livro livro = livroRepository.findById(itemCriarDTO.livroId()).
                orElseThrow(() -> new RuntimeException("Livro não encontrado"));


        Item item = itemMapper.paraEntidade(itemCriarDTO, livro);

        itemRepository.save(item);


    }

}
