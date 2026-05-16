import { HttpClient, HttpParams, httpResource } from '@angular/common/http';
import { inject, Injectable, Signal, signal } from '@angular/core';
import { Observable } from 'rxjs';
import { ICliente, Pageable } from '../interfaces/cliente.interface';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  
  private http = inject(HttpClient);

  private api = 'http://localhost:8080/clientes';

  page = signal(0);
  size = signal(10);

  clientesResource = httpResource<Pageable<ICliente>>(() =>({
    url: this.api,
    params:{
      page:this.page(),
      size: this.size()
    }
  }))

  getCliente(id: Signal<string | undefined | null>){
    return httpResource<ICliente>(()=> {
      const clienteId = id();
      if(!clienteId) return undefined;

      return {url: `${this.api}/${clienteId}`}
    });
  }

  

}
