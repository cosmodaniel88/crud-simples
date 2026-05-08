import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from "./layout/header/header";
import { Sidenav } from './layout/sidenav/sidenav';
import { LayoutService } from './layout/layout-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [Header, Sidenav, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('booksCrudUI');
  private layout = inject(LayoutService);

   isOpen = this.layout.sidenavOpen;
}
