import { Component, computed, inject, Signal } from '@angular/core';
import { PrimeComponentsModule } from '../../shared/prime-components/prime-components-module';
import { ICliente } from './interfaces/cliente.interface';
import { ClienteService } from './services/cliente.service';
import { Router } from '@angular/router';
import { ComprasService } from '../compras/compras-service';
import { toSignal } from '@angular/core/rxjs-interop';

@Component({
  selector: 'app-clientes',
  imports: [PrimeComponentsModule],
  templateUrl: './clientes.html',
  styleUrl: './clientes.scss',
})
export class Clientes {

  clientesService = inject(ClienteService);
  comprasService = inject(ComprasService);
  private router = inject(Router)

  public paginas = computed(() => {
    const total = this.clientesService.clientesResource.value()?.totalPages ?? 0;
    return Array.from({length: total}, (_, i) => i);
  });

  public getAllClientes():ICliente[] | undefined{
    return this.clientesService.clientesResource.value()?.content;
  }

  verDetalhes(id: number):void{
    this.router.navigate(['clientes/detalhes', id]);

  }




}
