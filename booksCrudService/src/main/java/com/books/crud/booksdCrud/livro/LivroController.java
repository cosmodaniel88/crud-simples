package com.books.crud.booksdCrud.livro;

import com.books.crud.booksdCrud.autor.AutorAtualizarDTO;
import com.books.crud.booksdCrud.autor.AutorCriarDTO;
import com.books.crud.booksdCrud.autor.AutorResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final  LivroService livroService;

    public LivroController(LivroService livroService, LivroMapper livroMapper) {
        this.livroService = livroService;}

    //Listar todos os livros'
    @GetMapping()
    public List<LivroResponseDTO> getTodosOsLivros(){
        return livroService.getTodosOsLivor();
    }

    //Buscar autor por id
    @GetMapping("/{id}")
    public LivroResponseDTO buscarLivroPorId(@PathVariable Long id){
        return livroService.getLivroPorId(id);
    }


    //Cadastrar novo autor
    @PostMapping()
    public LivroResponseDTO cadastrarNovoLivro(@Valid @RequestBody LivroCadastrarDTO livroCadastrarDTO){
        return livroService.cadastrarNovoLivro(livroCadastrarDTO);
    }

    //Atualizar autor
    @PutMapping("/{id}")
    public LivroResponseDTO atualizarAutor(@PathVariable Long id, @Valid @RequestBody LivroAtualizarDTO livroAtualizarDTO){
        return livroService.atualizarLivro(id, livroAtualizarDTO);
    }

    //Deletar Autor
    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
    }

    //Soft delete no autor
    @DeleteMapping("/{id}/desativar")
    public LivroResponseDTO softDelete(@PathVariable Long id){
        return livroService.softDeleteLivro(id);
    }

    @PutMapping("/{id}/ativar")
    public LivroResponseDTO ativar(@PathVariable Long id){
        return livroService.ativarLivro(id);
    }
}
