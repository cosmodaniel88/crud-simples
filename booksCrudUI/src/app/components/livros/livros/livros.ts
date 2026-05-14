import { HttpClient, httpResource } from '@angular/common/http';
import { Component, computed, inject, signal } from '@angular/core';
import { Pageable } from '../../clientes/interfaces/cliente.interface';
import { ILivro } from '../interface/ilivro';
import { LivrosService } from '../services/livros-service';
import { PrimeComponentsModule } from '../../../shared/prime-components/prime-components-module';
@Component({
  selector: 'app-livros',
  imports: [PrimeComponentsModule],
  templateUrl: './livros.html',
  styleUrl: './livros.scss',
})
export class Livros {
  
  livroService = inject(LivrosService)

  public paginas = computed(() => {
    const total = this.livroService.livrosResource.value()?.totalPages ?? 0;
    return Array.from({length: total}, (_, i) => i);
  });

  public getAllLivros():ILivro[] | undefined{
    return this.livroService.livrosResource.value()?.content;
  }
}
