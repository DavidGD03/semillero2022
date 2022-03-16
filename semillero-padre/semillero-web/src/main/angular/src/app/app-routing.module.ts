import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ComprarComicComponent } from './semillero/componentes/comprar-comic/comprar-comic.component';
import { GestionarComicComponent } from './semillero/componentes/gestionar-comic/gestionar-comic.component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';

const routes: Routes = [
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'gestionar-comic', component: GestionarComicComponent, data : null },
  { path: 'comprar-comic', component: ComprarComicComponent, data : null }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
