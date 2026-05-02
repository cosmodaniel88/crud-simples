import { Component, inject } from '@angular/core';
import { LayoutService } from '../layout-service';
import { SharedComponentesModule } from '../shared-componentes/shared-componentes-module';
@Component({
  selector: 'app-header',
  imports: [SharedComponentesModule],
  templateUrl: './header.html',
  styleUrl: './header.scss',
})
export class Header {

  private layout = inject(LayoutService);

  toggle(){
    this.layout.toggleSidenav();
  }
}
