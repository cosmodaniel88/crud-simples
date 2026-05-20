import { ICliente } from "../clientes/interfaces/cliente.interface";
import { IItem } from "../itens/item";


export interface ICompras {
    id:number,
    cliente:ICliente
    itens:IItem,
    valorTotalCompra:number,
    momentoDaCompra:Date
}
