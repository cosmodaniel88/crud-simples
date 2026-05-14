import { Component, inject } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { MenuModule } from 'primeng/menu';
import { LayoutService } from '../layout-service';
import { RouterLink } from "@angular/router";
@Component({
    selector: 'app-menu',
    imports: [MenuModule, RouterLink],
    templateUrl: './menu.html',
    styleUrl: './menu.scss',
})
export class Menu {
    items: MenuItem[] | undefined;

    private layout = inject(LayoutService);

   isOpen = this.layout.sidenavOpen;

    ngOnInit() {
        this.items = [
            { label: 'Início', icon: 'pi pi-home', routerLink:'/'},
            { label: 'Clientes', icon: 'pi pi-users', routerLink:'/clientes' },
            { label: 'Livros', icon: 'pi pi-book', routerLink:'/livros' },
        ];
    }

    // In your component
    menuPT = {
        root: { class: 'p-10'}
    }
}
