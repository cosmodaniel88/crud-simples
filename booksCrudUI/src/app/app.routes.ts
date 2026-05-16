import { Routes } from '@angular/router';
import { Home } from './layout/home/home';
import { Clientes } from './components/clientes/clientes';
import { Livros } from './components/livros/livros/livros';
import { Detalhes } from './components/clientes/paginas/detalhes/detalhes';

export const routes: Routes = [
    {path: '', component: Home},
    {path:'clientes', component: Clientes},
    {path:'livros', component:Livros},
    {path:'clientes/detalhes/:id', component: Detalhes}
];
