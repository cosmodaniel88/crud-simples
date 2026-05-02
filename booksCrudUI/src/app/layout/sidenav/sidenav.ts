import { Component, inject } from '@angular/core';
import { LayoutService } from '../layout-service';

@Component({
  selector: 'app-sidenav',
  imports: [],
  templateUrl: './sidenav.html',
  styleUrl: './sidenav.scss',
})
export class Sidenav {

  private layout = inject(LayoutService);

  isOpen = this.layout.sidenavOpen;
}
