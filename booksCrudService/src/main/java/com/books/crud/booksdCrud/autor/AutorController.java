package com.books.crud.booksdCrud.autor;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    //Buscar autor por id
    @GetMapping("/{id}")
    public AutorResponseDTO getAutorPorId(@PathVariable Long id){
        return autorService.getAutorPorId(id);
    }

    //Listar todos os autores
    @GetMapping()
    public List<AutorResponseDTO> getTodosOsAutores(){
        return autorService.getTodosOsAutores();
    }

    //Cadastrar novo autor
    @PostMapping()
    public AutorResponseDTO cadastrarNovoAutor(@Valid @RequestBody AutorCriarDTO autorCriarDTO){
        return autorService.cadastrarNovoAutor(autorCriarDTO);
    }

    //Atualizar autor
    @PutMapping("/{id}")
    public AutorResponseDTO atualizarAutor(@PathVariable Long id, @Valid @RequestBody AutorAtualizarDTO autorAtualizarDTO){
        return autorService.atualizarAutor(id, autorAtualizarDTO);
    }

    //Deletar Autor
    @DeleteMapping("/{id}")
    public void deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
    }

    //Soft delete no autor
    @DeleteMapping("/{id}/desativar")
    public AutorResponseDTO softDelete(@PathVariable Long id){
        return autorService.softDeleteAutor(id);
    }

    @PutMapping("/{id}/ativar")
    public AutorResponseDTO ativar(@PathVariable Long id){
        return autorService.ativarAutor(id);
    }
}
