import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/auth/login/login.component';
import { RegistroComponent } from './components/auth/registro/registro.component';
import { CalendarioComponent } from './components/calendario/calendario.component';
import { MaestrosCrudComponent } from './components/maestros/maestros-crud.component';
import { MainComponent } from './components/main/main.component';

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
        path: 'calendarizador/:id',
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
