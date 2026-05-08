import { Component, inject } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { MenuModule } from 'primeng/menu';
import { LayoutService } from '../layout-service';
@Component({
    selector: 'app-menu',
    imports: [MenuModule],
    templateUrl: './menu.html',
    styleUrl: './menu.scss',
})
export class Menu {
    items: MenuItem[] | undefined;

    private layout = inject(LayoutService);

   isOpen = this.layout.sidenavOpen;

    ngOnInit() {
        this.items = [
            { label: 'Início', icon: 'pi pi-home' },
            { label: 'Clientes', icon: 'pi pi-users' },
            { label: 'Livros', icon: 'pi pi-book' },
        ];
    }

    // In your component
    menuPT = {
        root: { class: 'p-10'}
    }
}
