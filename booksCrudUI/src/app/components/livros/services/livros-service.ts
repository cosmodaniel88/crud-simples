import { inject, Injectable, signal } from '@angular/core';
import { Pageable } from '../../clientes/interfaces/cliente.interface';
import { ILivro } from '../interface/ilivro';
import { HttpClient, httpResource } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class LivrosService {

  private http = inject(HttpClient)

    private api = 'http://localhost:8080/livros';

    page = signal(0);
    size = signal(10);

    livrosResource = httpResource<Pageable<ILivro>>(() => ({
      url:this.api,
      params:{
        page:this.page(),
        size: this.size()
      }
    }))
  
}
