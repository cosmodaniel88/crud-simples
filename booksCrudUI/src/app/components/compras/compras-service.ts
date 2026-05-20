import { httpResource } from '@angular/common/http';
import { Injectable, Signal } from '@angular/core';
import { ICompras } from './compras';
import { Pageable } from '../clientes/interfaces/cliente.interface';

@Injectable({
  providedIn: 'root',
})
export class ComprasService {

  private api = 'http://localhost:8080/compras';

  getComprasPorCliente(id:Signal<string|undefined|null>){
    return httpResource<Pageable<ICompras>>(()=>{
      const clienteId = id();

      if(!clienteId) return undefined;

      return{url: `${this.api}/${clienteId}/cliente`}

    });

  }
  
}
