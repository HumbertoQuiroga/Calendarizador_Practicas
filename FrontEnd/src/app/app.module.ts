import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from  '@angular/common/http';
import { LoginComponent } from './components/auth/login/login.component';
import { RegistroComponent } from './components/auth/registro/registro.component';
import { CalendarioComponent } from './components/calendario/calendario.component';
import { MainComponent } from './components/main/main.component';
import { MaestrosCrudComponent } from './components/maestros/maestros-crud.component';

import { FormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog'
import {MatButtonModule} from '@angular/material/button';
import { ConfirmDialogMessageComponent } from './components/confirm-dialog-message/confirm-dialog-message.component'

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistroComponent,
    CalendarioComponent,
    MainComponent,
    MaestrosCrudComponent,
    ConfirmDialogMessageComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,
    MatDialogModule,
    MatButtonModule
  ],
  entryComponents: [ConfirmDialogMessageComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
