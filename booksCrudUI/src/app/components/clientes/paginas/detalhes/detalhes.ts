import { Component, inject, OnInit, signal } from '@angular/core';
import { DetalhesPerfil } from '../../../../layout/detalhes-perfil/detalhes-perfil';
import { PrimeComponentsModule } from '../../../../shared/prime-components/prime-components-module';
import { ClienteService } from '../../services/cliente.service';
import { ICliente } from '../../interfaces/cliente.interface';
import { ActivatedRoute } from '@angular/router';
import { toSignal } from '@angular/core/rxjs-interop';
import { map } from 'rxjs';
@Component({
  selector: 'app-detalhes',
  imports: [DetalhesPerfil, PrimeComponentsModule],
  templateUrl: './detalhes.html',
  styleUrl: './detalhes.scss',
})
export class Detalhes {

  private route = inject(ActivatedRoute)
  private clienteService = inject(ClienteService)

  private id = toSignal(
    this.route.paramMap.pipe(map(p => p.get('id')))
  );

  clienteResource = this.clienteService.getCliente(this.id);

  products = [

  ]
}
