
export interface Pageable<T>{
    content: T[];
    totatlElements: number;
    totalPages:number;
    number:number
    size:number;
    first:boolean;
    last:boolean
}


export interface ICliente {
    id:number
    ativo:boolean
    cpf:string
    foto:string
    nome:string
    dataNascimento:Date
}
