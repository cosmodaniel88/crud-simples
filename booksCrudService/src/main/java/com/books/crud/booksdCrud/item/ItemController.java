package com.books.crud.booksdCrud.item;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public void cadastrarItem(@RequestBody @Valid RegistrarItemDTO registrarItemDTO){

        itemService.cadastrarNovoItem(registrarItemDTO);

    }
}
