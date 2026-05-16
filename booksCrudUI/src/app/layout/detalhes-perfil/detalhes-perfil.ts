import { Component, input } from '@angular/core';
import { Avatar } from "primeng/avatar";
import { PrimeComponentsModule } from '../../shared/prime-components/prime-components-module';
import { ICliente } from '../../components/clientes/interfaces/cliente.interface';

@Component({
  selector: 'app-detalhes-perfil',
  imports: [Avatar, PrimeComponentsModule],
  templateUrl: './detalhes-perfil.html',
  styleUrl: './detalhes-perfil.scss',
})
export class DetalhesPerfil {

  cliente = input.required<ICliente>();

}
