import { Injectable, signal } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LayoutService {

  sidenavOpen = signal(true);

  toggleSidenav(){
    this.sidenavOpen.update(ov => !ov);
  }
  
}
