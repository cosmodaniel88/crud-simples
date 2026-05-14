import { Component, inject } from '@angular/core';
import { LayoutService } from '../layout-service';
import { SharedComponentesModule } from '../shared-componentes/shared-componentes-module';
import { ToolbarModule } from 'primeng/toolbar';
import { PrimeComponentsModule } from '../../shared/prime-components/prime-components-module';
@Component({
  selector: 'app-header',
  imports: [SharedComponentesModule, ToolbarModule, PrimeComponentsModule],
  templateUrl: './header.html',
  styleUrl: './header.scss',
})
export class Header {

  private layout = inject(LayoutService);

  toggle(){
    this.layout.toggleSidenav();
  }
}
