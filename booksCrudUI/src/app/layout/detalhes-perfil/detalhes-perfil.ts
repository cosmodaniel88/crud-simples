import { Component, computed, input } from '@angular/core';
import { Avatar } from "primeng/avatar";
import { PrimeComponentsModule } from '../../shared/prime-components/prime-components-module';
import { ICliente } from '../../components/clientes/interfaces/cliente.interface';

type BadgeSeverity = 'success' | 'danger';

interface badgeConfig{
  value:string,
  severity:BadgeSeverity
}

@Component({
  selector: 'app-detalhes-perfil',
  imports: [Avatar, PrimeComponentsModule],
  templateUrl: './detalhes-perfil.html',
  styleUrl: './detalhes-perfil.scss',
})
export class DetalhesPerfil {

  cliente = input.required<ICliente>();

  badgeConfig = computed<badgeConfig>(() =>{
    
    const ativo = this.cliente()?.ativo;


    return ativo ? {value:'ativo', severity: 'success'} : {value: 'inativo', severity: "danger"}

  });
}
