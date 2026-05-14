import { Component, computed, inject } from '@angular/core';
import { PrimeComponentsModule } from '../../shared/prime-components/prime-components-module';
import { ICliente } from './interfaces/cliente.interface';
import { ClienteService } from './services/cliente.service';

@Component({
  selector: 'app-clientes',
  imports: [PrimeComponentsModule],
  templateUrl: './clientes.html',
  styleUrl: './clientes.scss',
})
export class Clientes {

  clientesService = inject(ClienteService);

  public paginas = computed(() => {
    const total = this.clientesService.clientesResource.value()?.totalPages ?? 0;
    return Array.from({length: total}, (_, i) => i);
  });

  public getAllClientes():ICliente[] | undefined{
    return this.clientesService.clientesResource.value()?.content;
  }


}
