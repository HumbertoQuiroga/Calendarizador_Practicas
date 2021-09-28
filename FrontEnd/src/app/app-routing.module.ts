import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegistroComponent } from './auth/registro/registro.component';
import { CalendarioComponent } from './calendario/calendario.component';
import { MaestrosCrudComponent } from './maestros/maestros-crud/maestros-crud.component';
import { MainComponent } from './main/main.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'registro',
    component: RegistroComponent
  },
  {
    path: 'index',
    component: MainComponent,
    children: [
      {
        path: 'calendarizador',
        component: CalendarioComponent
      },
      {
        path: 'maestros',
        component: MaestrosCrudComponent
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
