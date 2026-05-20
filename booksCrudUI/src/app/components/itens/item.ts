import { ILivro } from "../livros/interface/ilivro";

export interface IItem {
    livro:ILivro,
    quantidade:number,
    valorTotalItem:number

}
